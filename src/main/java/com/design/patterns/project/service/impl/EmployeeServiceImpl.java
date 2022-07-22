package com.design.patterns.project.service.impl;

import com.design.patterns.project.config.NonNullBeanProperties;
import com.design.patterns.project.dto.EmployeeDTO;
import com.design.patterns.project.dto.EmployeeIUDTO;
import com.design.patterns.project.dto.mapper.EmployeeMapper;
import com.design.patterns.project.models.Employee;
import com.design.patterns.project.models.User;
import com.design.patterns.project.repository.EmployeeRepository;
import com.design.patterns.project.repository.RoleRepository;
import com.design.patterns.project.service.EmployeeService;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeDTO> findAll() {
        return  employeeMapper.toEmployeeDTO(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findByEmployeeId(Integer employeeId) {
        return employeeMapper.toEmployeeDTO(employeeRepository.findByEmployeeId(employeeId).get());
    }

    @Override
    public EmployeeDTO findByEmployeeDNI(String employeeDNI) {
        return employeeMapper.toEmployeeDTO(employeeRepository.findByEmployeeDNI(employeeDNI));
    }

    @Override
    public boolean save(EmployeeIUDTO employeeIUDTO) {
        try {
            Employee employee = employeeMapper.toEmployee(employeeIUDTO);
            User user = new User();
            String username = employee.getFirstName().split(" ")[0].toLowerCase().charAt(0) + employee.getLastName().toLowerCase();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(employee.getDni()));
            user.setRole(roleRepository.findByRole("EMPLOYEE").get());
            employee.setUser(user);
            employeeRepository.save(employee);
            return true;
        } catch(Exception e){
            log.error("error save employee" + e.getMessage());
            return false;
        }
    }

    @Override
    public EmployeeDTO update(Integer employeeId, EmployeeIUDTO employeeIUDTO) {
        try{
            Employee employeeRequest = employeeMapper.toEmployee(employeeIUDTO);
            Employee employeeUpdate = employeeMapper.toEmployeeUpdate(this.findByEmployeeId(employeeId));
            if(employeeUpdate != null){
                BeanUtilsBean beanUtils = new NonNullBeanProperties();
                beanUtils.copyProperties(employeeUpdate, employeeRequest);
                employeeRepository.save(employeeUpdate);
                return employeeMapper.toEmployeeDTO(employeeUpdate);
            }else{
                throw new Exception("employee not found");
            }
        }catch(Exception e){
            log.error("error update user" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteByEmployeeId(Integer employeeId) {
        try{
            if(employeeRepository.findByEmployeeId(employeeId)!=null){
                employeeRepository.deleteByEmployeeId(employeeId);
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
