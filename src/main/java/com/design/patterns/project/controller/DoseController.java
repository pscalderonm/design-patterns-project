package com.design.patterns.project.controller;

import com.design.patterns.project.dto.DoseDTO;
import com.design.patterns.project.dto.DoseIUDTO;
import com.design.patterns.project.models.Response;
import com.design.patterns.project.service.impl.DoseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    private DoseServiceImpl doseServiceImpl;

    private static HttpStatus status;

    private static Response response;

    @GetMapping("/")
    @Operation(summary = "Returns a dose list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a Dose List"),
            @ApiResponse(responseCode = "400", description = "Dose List can not be returned"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> findAll() {
        List<DoseDTO> dose = doseServiceImpl.findAll();
        if(dose.isEmpty()){
            status = HttpStatus.BAD_REQUEST;
            response =  Response.builder().status(status.toString()).data("No data found").build();
        }else{
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(dose).build();
        }
        return new ResponseEntity<>(response,status);
    }


    @PostMapping("/")
    @Operation(summary = "Save dose")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dose saved"),
            @ApiResponse(responseCode = "400", description = "Dose can not be saved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> save(@RequestBody DoseIUDTO doseIUDTO){
        boolean dose = doseServiceImpl.save(doseIUDTO);
        if(dose){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(doseIUDTO).build();
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("dose not save").build();
        }
        return new ResponseEntity<>(response,status);
    }




}
