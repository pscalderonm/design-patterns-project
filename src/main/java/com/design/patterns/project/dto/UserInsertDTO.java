package com.design.patterns.project.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = UserInsertDTO.UserInsertDTOBuilder.class)
public class UserInsertDTO {

    private String username;

    private String password;

    private String roleName;

    @JsonPOJOBuilder(withPrefix = "")
    public static class UserInsertDTOBuilder{

    }
}
