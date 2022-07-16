package com.design.patterns.project.service;

import com.design.patterns.project.dto.UserDTO;
import com.design.patterns.project.dto.UserInsertDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO findByUsername(String username);
    void save(UserInsertDTO user);
}
