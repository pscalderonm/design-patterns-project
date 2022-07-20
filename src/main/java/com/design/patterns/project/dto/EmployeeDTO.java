package com.design.patterns.project.dto;

import com.design.patterns.project.models.Dose;
import com.design.patterns.project.models.User;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@JsonDeserialize(builder = EmployeeDTO.EmployeeDTOBuilder.class)
public class EmployeeDTO {
    private Integer id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateBirth;
    private String address;
    private String phone;
    private Boolean vaccineStatus;
    private List<Dose> doses;

    private User user;

    @JsonPOJOBuilder(withPrefix = "")
    public static class EmployeeDTOBuilder{

    }
}
