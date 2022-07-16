package com.design.patterns.project.service.impl;

import com.design.patterns.project.dto.RoleDTO;
import com.design.patterns.project.dto.mapper.RoleMapper;
import com.design.patterns.project.models.Role;
import com.design.patterns.project.repository.RoleRepository;
import com.design.patterns.project.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    
    private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleDTO> findAll() {
        return roleMapper.toRolesDTO(roleRepository.findAll());
    }

    @Override
    public RoleDTO findByRole(String roleName ) {
        Optional<Role> role = roleRepository.findByRole(roleName);
        return role.map(value -> roleMapper.toRoleDTO(value)).orElse(null);
    }

    @Override
    public boolean save(RoleDTO roleDto) {
        try{
            Role role = roleMapper.toRole(roleDto);
            roleRepository.save(role);
            return true;
        }catch(Exception e){
            log.error(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean deleteByRole(String roleName) {
        try{
            if(roleRepository.findByRole(roleName).isPresent()){
                roleRepository.deleteByRole(roleName);
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
