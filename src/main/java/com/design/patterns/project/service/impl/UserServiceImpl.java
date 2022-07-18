package com.design.patterns.project.service.impl;

import com.design.patterns.project.config.NonNullBeanProperties;
import com.design.patterns.project.dto.UserDTO;
import com.design.patterns.project.dto.UserIUDTO;
import com.design.patterns.project.dto.mapper.UserMapper;
import com.design.patterns.project.models.User;
import com.design.patterns.project.repository.RoleRepository;
import com.design.patterns.project.repository.UserRepository;
import com.design.patterns.project.service.UserService;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> findAll() {
        return userMapper.toUsersDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userMapper.toUserDTO(userRepository.findByUsername(username));
    }

    @Override
    public boolean save(UserIUDTO userDTO) {
        try{
            User user = userMapper.toUser(userDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(roleRepository.findByRole(userDTO.getRoleName().toUpperCase()).get());
            userRepository.save(user);
            return true;
        }catch(Exception e){
            log.error("error save user" + e.getMessage());
            return false;
        }
    }

    @Override
    public UserDTO update(String username, UserIUDTO user) {
        try{
            User userRequest = userMapper.toUser(user);
            User userUpdate = userMapper.toUserUpdate(this.findByUsername(username));
            if(userUpdate != null){
                if (user.getRoleName()!=null)
                    userRequest.setRole(roleRepository.findByRole(user.getRoleName().toUpperCase()).get());
                if(user.getPassword()!=null)
                    userRequest.setPassword(passwordEncoder.encode(user.getPassword()));
                BeanUtilsBean beanUtils = new NonNullBeanProperties();
                beanUtils.copyProperties(userUpdate, userRequest);
                userRepository.save(userUpdate);
                return userMapper.toUserDTO(userUpdate);
            }else{
                throw new Exception("user not found");
            }
        }catch(Exception e){
            log.error("error update user" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteByUsername(String username) {
        try{
            if(userRepository.findByUsername(username)!=null){
                userRepository.deleteByUsername(username);
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }


}
