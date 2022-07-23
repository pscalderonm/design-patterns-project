package com.design.patterns.project.repository.crud;

import com.design.patterns.project.models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface DoseCrudRepository extends JpaRepository<Dose,Integer>{
    Optional<Dose> findByEmployee(String employee);

    List<Dose> findByEmployee_Dni(String employee_dni);

    @Transactional
    void deleteById(Integer id);

}
