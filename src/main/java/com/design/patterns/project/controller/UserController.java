package com.design.patterns.project.controller;

import com.design.patterns.project.dto.UserDTO;
import com.design.patterns.project.dto.UserInsertDTO;
import com.design.patterns.project.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public List<UserDTO> findAll() {
        return userServiceImpl.findAll();
    }

    @PostMapping("/")
    public void save(@RequestBody UserInsertDTO userDTO){
        userServiceImpl.save(userDTO);
    }


}
