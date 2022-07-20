package com.design.patterns.project.dto;

import com.design.patterns.project.constants.VaccineEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonDeserialize(builder = DoseIUDTO.DoseIUDTOBuilder.class)
public class DoseIUDTO {

    private Integer doseNumber;
    private Date doseDate;
    private VaccineEnum vaccineEnum;


    @JsonPOJOBuilder(withPrefix = "")
    public static class DoseIUDTOBuilder{

    }
}
