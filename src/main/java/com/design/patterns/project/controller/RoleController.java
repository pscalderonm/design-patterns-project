package com.design.patterns.project.controller;

import com.design.patterns.project.dto.RoleDTO;
import com.design.patterns.project.models.Response;
import com.design.patterns.project.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    private static HttpStatus status;

    private static Response response;


    @GetMapping("/")
    public ResponseEntity<Response> findAll() {
        List<RoleDTO> roles = roleServiceImpl.findAll();
        if(roles.isEmpty()){
            status = HttpStatus.BAD_REQUEST;
            response =  Response.builder().status(status.toString()).data("No data found").build();
        }else{
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(roles).build();
        }
        return new ResponseEntity<>(response,status);
    }

    @GetMapping("/{roleName}")
    public ResponseEntity<Response> findById(@PathVariable String roleName){
        RoleDTO role = roleServiceImpl.findByRole(roleName);
        if(role != null){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(role).build();
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("No role found").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @PostMapping("/")
    public ResponseEntity<Response> save(@RequestBody RoleDTO roleDTO){
        boolean role = roleServiceImpl.save(roleDTO);
        if(role){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(roleDTO).build();
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("role not save").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @DeleteMapping("/{roleName}")
    public ResponseEntity<Response> delete(@PathVariable String roleName){
        boolean role = roleServiceImpl.deleteByRole(roleName);
        if(role){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data("role delete success").build();
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("role not delete").build();
        }
        return new ResponseEntity<>(response,status);
    }
}
