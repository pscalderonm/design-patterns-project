package com.design.patterns.project.service;

import com.design.patterns.project.constants.VaccineEnum;
import com.design.patterns.project.dto.DoseDTO;
import com.design.patterns.project.dto.DoseIUDTO;

import java.util.Date;
import java.util.List;

public interface DoseService {

    List<DoseDTO> findAll();

    List<DoseDTO> findByEmployee(String employee);

    boolean save(DoseIUDTO doseIUDTO);

    DoseDTO update(Integer doseNumber, Date doseDate, VaccineEnum vaccineEnum);

    //boolean deleteByEmployeeDoseNumber(String employee, Integer DoseNumber);


}
