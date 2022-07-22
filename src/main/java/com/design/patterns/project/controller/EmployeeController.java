package com.design.patterns.project.controller;

import com.design.patterns.project.dto.EmployeeDTO;
import com.design.patterns.project.dto.EmployeeIUDTO;
import com.design.patterns.project.models.Response;
import com.design.patterns.project.service.impl.EmployeeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@SecurityRequirement(name = "basicAuth")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    private static HttpStatus status;

    private static Response response;

    @GetMapping("/")
    @Operation(summary = "Returns a employee list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a Role List"),
            @ApiResponse(responseCode = "400", description = "Role List can not be returned"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> findAll() {
        List<EmployeeDTO> employees = employeeServiceImpl.findAll();
        if(employees.isEmpty()){
            status = HttpStatus.BAD_REQUEST;
            response =  Response.builder().status(status.toString()).data("No data found").build();
        }else{
            status = HttpStatus.OK;
            response =  Response.builder().status(status.toString()).data(employees).build();
        }
        return new ResponseEntity<>(response,status);
    }

    @GetMapping("/{employeeId}")
    @Operation(summary = "Returns a employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a Role"),
            @ApiResponse(responseCode = "400", description = "Role can not be returned"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> findById(@PathVariable Integer employeeId) {
        EmployeeDTO employee = employeeServiceImpl.findByEmployeeId(employeeId);
        if(employee == null){
            status = HttpStatus.BAD_REQUEST;
            response =  Response.builder().status(status.toString()).data("No data found").build();
        }else{
            status = HttpStatus.OK;
            response =  Response.builder().status(status.toString()).data(employee).build();
        }
        return new ResponseEntity<>(response,status);
    }

    @GetMapping("/dni/{employeeDni}")
    @Operation(summary = "Returns a employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a Role"),
            @ApiResponse(responseCode = "400", description = "Role can not be returned"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> findByDni(@PathVariable String employeeDni) {
        EmployeeDTO employee = employeeServiceImpl.findByEmployeeDNI(employeeDni);
        if(employee == null){
            status = HttpStatus.BAD_REQUEST;
            response =  Response.builder().status(status.toString()).data("No data found").build();
        }else{
            status = HttpStatus.OK;
            response =  Response.builder().status(status.toString()).data(employee).build();
        }
        return new ResponseEntity<>(response,status);
    }

    @PostMapping("/")
    @Operation(summary = "Save employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role saved"),
            @ApiResponse(responseCode = "400", description = "Role can not be saved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> save(@RequestBody EmployeeIUDTO employeeIUDTO){
        boolean employee = employeeServiceImpl.save(employeeIUDTO);
        if(employee){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(employeeIUDTO).build();
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("employee not save").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @PutMapping("/{employeeId}")
    @Operation(summary = "Update employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role updated"),
            @ApiResponse(responseCode = "400", description = "Role can not be updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response>  update(@PathVariable Integer employeeId, @RequestBody EmployeeIUDTO employeeIUDTO){
        EmployeeDTO employee = employeeServiceImpl.update(employeeId,employeeIUDTO);
        if(employee!=null){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(employee).build();
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("user not update").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @DeleteMapping("/{employeeId}")
    @Operation(summary = "Delete employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role deleted"),
            @ApiResponse(responseCode = "400", description = "Role can not be deleted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> delete(@PathVariable Integer employeeId){
        boolean employee = employeeServiceImpl.deleteByEmployeeId(employeeId);
        if(employee){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data("user delete success").build();
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("user not delete").build();
        }
        return new ResponseEntity<>(response,status);
    }
}
