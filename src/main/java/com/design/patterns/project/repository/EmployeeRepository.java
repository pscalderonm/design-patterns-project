package com.design.patterns.project.repository;

import com.design.patterns.project.models.Employee;
import com.design.patterns.project.repository.crud.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    public List<Employee> findAll() {return employeeCrudRepository.findAll(); }

    public Employee findByEmployeeDNI(String employeeDNI){ return employeeCrudRepository.findByDni(employeeDNI);}

    public Optional<Employee> findByEmployeeId(Integer employeeId) {return employeeCrudRepository.findById(employeeId);}

    public void save(Employee employee){employeeCrudRepository.save(employee);}

    public void deleteByEmployeeId(Integer employeeId){ employeeCrudRepository.deleteById(employeeId);}
}
