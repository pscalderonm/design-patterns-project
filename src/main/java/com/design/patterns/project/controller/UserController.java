package com.design.patterns.project.controller;

import com.design.patterns.project.dto.UserDTO;
import com.design.patterns.project.dto.UserIUDTO;
import com.design.patterns.project.models.Response;
import com.design.patterns.project.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "basicAuth")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    private static HttpStatus status;

    private static Response response;

    @GetMapping("/")
    public ResponseEntity<Response> findAll() {
        List<UserDTO> users = userServiceImpl.findAll();
        if(users.isEmpty()){
            status = HttpStatus.BAD_REQUEST;
            response =  Response.builder().status(status.toString()).data("No data found").build();
        }else{
            status = HttpStatus.OK;
            response =  Response.builder().status(status.toString()).data(users).build();
        }
        return new ResponseEntity<>(response,status);
    }

    @PostMapping("/")
    public ResponseEntity<Response> save(@RequestBody UserIUDTO userDTO){
        boolean user = userServiceImpl.save(userDTO);
        if(user){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(userDTO).build();
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("user not save").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Response>  update(@PathVariable String username, @RequestBody UserIUDTO userDTO){
        UserDTO user = userServiceImpl.update(username,userDTO);
        if(user!=null){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(user).build();
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("user not update").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Response> delete(@PathVariable String username){
        boolean user = userServiceImpl.deleteByUsername(username);
        if(user){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data("user delete success").build();
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("user not delete").build();
        }
        return new ResponseEntity<>(response,status);
    }

}
