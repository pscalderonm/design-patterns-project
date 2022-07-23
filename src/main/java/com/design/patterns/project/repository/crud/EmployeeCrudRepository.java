package com.design.patterns.project.repository.crud;

import com.design.patterns.project.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmployeeCrudRepository extends JpaRepository <Employee, Integer>{
    Employee findByDni(String employeeDNI);

}
