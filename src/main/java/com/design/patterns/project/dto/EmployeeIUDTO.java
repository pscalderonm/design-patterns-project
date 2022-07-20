package com.design.patterns.project.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder
@JsonDeserialize(builder = EmployeeIUDTO.EmployeeIUDTOBuilder.class)
public class EmployeeIUDTO {
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateBirth;
    private String address;
    private String phone;
    private Boolean vaccineStatus;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EmployeeIUDTOBuilder{

    }
}
