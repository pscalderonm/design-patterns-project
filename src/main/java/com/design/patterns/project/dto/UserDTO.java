package com.design.patterns.project.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = UserDTO.UserDTOBuilder.class)
public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private RoleDTO roleDTO;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserDTOBuilder{

    }
}
