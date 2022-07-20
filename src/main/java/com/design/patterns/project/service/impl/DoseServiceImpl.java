package com.design.patterns.project.service.impl;

import com.design.patterns.project.config.NonNullBeanProperties;
import com.design.patterns.project.constants.VaccineEnum;
import com.design.patterns.project.dto.DoseDTO;
import com.design.patterns.project.dto.DoseIUDTO;
import com.design.patterns.project.dto.mapper.DoseMapper;
import com.design.patterns.project.models.Dose;
import com.design.patterns.project.repository.DoseRepository;
import com.design.patterns.project.service.DoseService;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoseServiceImpl implements DoseService {

    private static final Logger log = LoggerFactory.getLogger(DoseServiceImpl.class);

    @Autowired
    private DoseRepository doseRepository;

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
            doseRepository.save(dose);
            return true;

        }catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public DoseDTO update(Integer doseNumber, Date doseDate, VaccineEnum vaccineEnum) {
        return null;
    }

    //@Override
    //public boolean deleteByEmployeeDoseNumber(String employee, Integer DoseNumber) {
    //    return false;
    //}


}
