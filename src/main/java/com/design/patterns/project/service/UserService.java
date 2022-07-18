package com.design.patterns.project.service;

import com.design.patterns.project.dto.UserDTO;
import com.design.patterns.project.dto.UserIUDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO findByUsername(String username);
    boolean save(UserIUDTO user);
    UserDTO update(String username, UserIUDTO user);
    boolean deleteByUsername(String username);

}
