package com.design.patterns.project.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = Response.ResponseBuilder.class)
public class Response{

    private String status;
    private Object data;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ResponseBuilder{
    }
}
