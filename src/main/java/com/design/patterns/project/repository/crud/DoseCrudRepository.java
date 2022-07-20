package com.design.patterns.project.repository.crud;

import com.design.patterns.project.models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DoseCrudRepository extends JpaRepository<Dose,Integer>{
    Optional<Dose> findByEmployee(String employee);

    //@Transactional
    //void deleteByEmployeeDoseNumber(String employee, Integer doseNumber);

}
