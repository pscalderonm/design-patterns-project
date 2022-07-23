package com.design.patterns.project.service;

import com.design.patterns.project.constants.VaccineEnum;
import com.design.patterns.project.dto.DoseDTO;
import com.design.patterns.project.dto.DoseIUDTO;
import com.design.patterns.project.models.Dose;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

public interface DoseService {

    List<DoseDTO> findAll();

    List<DoseDTO> findByEmployee(String employee);

    boolean save(DoseIUDTO doseIUDTO);

    public Dose update(Integer id, DoseIUDTO dose) throws InvocationTargetException, IllegalAccessException;

    List<DoseDTO> findByDni(String employee_dni);

    boolean deleteById(Integer dose_id);


}
