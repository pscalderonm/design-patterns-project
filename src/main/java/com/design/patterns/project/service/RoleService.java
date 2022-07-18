package com.design.patterns.project.service;


import com.design.patterns.project.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> findAll();
    RoleDTO findByRole(String roleName);
    boolean save(RoleDTO roleDTO);
    RoleDTO update(String roleName, RoleDTO role);
    boolean deleteByRole(String roleName);
}
