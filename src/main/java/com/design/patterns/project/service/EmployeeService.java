package com.design.patterns.project.service;

import com.design.patterns.project.dto.EmployeeDTO;
import com.design.patterns.project.dto.EmployeeIUDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findByEmployeeId(Integer employeeId);
    EmployeeDTO findByEmployeeDNI(String employeeDNI);
    boolean save(EmployeeIUDTO employeeIUDTO);
    EmployeeDTO update(Integer employeeId, EmployeeIUDTO employeeIUDTO);
    boolean deleteByEmployeeId(Integer employeeId);
}
