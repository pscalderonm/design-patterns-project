package com.design.patterns.project.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = RoleDTO.RoleDTOBuilder.class)
public class RoleDTO {

    private Integer id;

    private String name;

    private String description;

    @JsonPOJOBuilder(withPrefix = "")
    public static class RoleDTOBuilder{

    }
}
