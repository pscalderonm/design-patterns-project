package com.design.patterns.project.service.impl;

import com.design.patterns.project.dto.UserDTO;
import com.design.patterns.project.dto.UserInsertDTO;
import com.design.patterns.project.dto.mapper.UserMapper;
import com.design.patterns.project.models.User;
import com.design.patterns.project.repository.RoleRepository;
import com.design.patterns.project.repository.UserRepository;
import com.design.patterns.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUsersDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userMapper.toUserDTO(userRepository.findByUsername(username));
    }

    @Override
    public void save(UserInsertDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        user.setRole(roleRepository.findByRole(userDTO.getRoleName()).get());
        userRepository.save(user);
    }
}
