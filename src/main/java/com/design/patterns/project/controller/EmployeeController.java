package com.design.patterns.project.controller;

import com.design.patterns.project.dto.EmployeeDTO;
import com.design.patterns.project.dto.EmployeeIUDTO;
import com.design.patterns.project.models.Response;
import com.design.patterns.project.service.impl.EmployeeServiceImpl;
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

    @PostMapping("/")
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
