package com.design.patterns.project.service.impl;

import com.design.patterns.project.config.NonNullBeanProperties;
import com.design.patterns.project.constants.VaccineEnum;
import com.design.patterns.project.dto.DoseDTO;
import com.design.patterns.project.dto.DoseIUDTO;
import com.design.patterns.project.dto.mapper.DoseMapper;
import com.design.patterns.project.models.Dose;
import com.design.patterns.project.models.Employee;
import com.design.patterns.project.repository.DoseRepository;
import com.design.patterns.project.repository.EmployeeRepository;
import com.design.patterns.project.service.DoseService;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoseServiceImpl implements DoseService {

    private static final Logger log = LoggerFactory.getLogger(DoseServiceImpl.class);

    @Autowired
    private DoseRepository doseRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DoseMapper doseMapper;


    @Override
    public List<DoseDTO> findAll() { return doseMapper.toDoseesDTO(doseRepository.findAll()); }

    @Override
    public List<DoseDTO> findByEmployee(String employee) {
        return null;
    }


    @Override
    public boolean save(DoseIUDTO doseDTO) {
        try{
            Dose dose = doseMapper.toDose(doseDTO);
            Employee employee = employeeRepository.findByEmployeeDNI(doseDTO.getEmployeeDni());
            if(!employee.getVaccineStatus())
                throw new Exception("El empleado no se encuentra con estado vacunado");
            dose.setEmployee(employee);
            doseRepository.save(dose);
            return true;

        }catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Dose update(Integer id, DoseIUDTO dose) throws InvocationTargetException, IllegalAccessException {
        Dose doseToUpdate = doseRepository.findById(id).get();
        BeanUtilsBean beanUtils = new NonNullBeanProperties();
        beanUtils.copyProperties(doseToUpdate, dose);
        doseRepository.save(doseToUpdate);
        return doseToUpdate;
    }

    @Override
    public List<DoseDTO> findByDni(String employee_dni) {
        return doseMapper.toDoseesDTO(doseRepository.findByDni(employee_dni));
    }

    @Override
    public boolean deleteById(Integer dose_id) {
        try{
            if(doseRepository.findById(dose_id).isPresent()){
                doseRepository.deleteById(dose_id);
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }


    //@Override
    //public boolean deleteByEmployeeDoseNumber(String employee, Integer DoseNumber) {
    //    return false;
    //}


}
