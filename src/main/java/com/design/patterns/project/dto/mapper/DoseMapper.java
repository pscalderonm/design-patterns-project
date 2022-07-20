package com.design.patterns.project.dto.mapper;

import com.design.patterns.project.dto.DoseDTO;
import com.design.patterns.project.dto.DoseIUDTO;
import com.design.patterns.project.models.Dose;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoseMapper {

    @Mappings({
            @Mapping(source = "doseNumber", target = "doseNumber"),
            @Mapping(source = "vaccineEnum", target = "vaccineEnum"),
            @Mapping(source = "doseDate", target = "doseDate")
    })

    DoseDTO toDoseDTO(Dose dose);

    List<DoseDTO> toDoseesDTO(List<Dose> dosees);

    @InheritInverseConfiguration
    Dose toDoseUpdate(DoseDTO doseDTO);


    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    Dose toDose(DoseIUDTO doseDTO);



}
