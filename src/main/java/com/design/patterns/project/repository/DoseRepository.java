package com.design.patterns.project.repository;

import com.design.patterns.project.models.Dose;
import com.design.patterns.project.repository.crud.DoseCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class DoseRepository {

    @Autowired
    private DoseCrudRepository doseCrudRepository;

    public List<Dose> findAll(){ return doseCrudRepository.findAll(); }

    public Optional<Dose> findByEmployee(String employee){
        return doseCrudRepository.findByEmployee(employee);
    }

    public void save(Dose dose){
        doseCrudRepository.save(dose);
    }

    public Optional<Dose> findById(Integer id) {
        return doseCrudRepository.findById(id);
    }


    public List<Dose> findByDni(String employee_dni) {
        return doseCrudRepository.findByEmployee_Dni(employee_dni);
    }

    public void deleteById(Integer dose_id){
        doseCrudRepository.deleteById(dose_id);
    }


}
