package com.design.patterns.project.repository;

import com.design.patterns.project.models.Role;
import com.design.patterns.project.repository.crud.RoleCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository {

    @Autowired
    private RoleCrudRepository roleCrudRepository;

    public List<Role> findAll(){
        return roleCrudRepository.findAll();
    }

    public Optional<Role> findByRole(String roleName){ return roleCrudRepository.findByRole(roleName);}

    public void save(Role role){
        roleCrudRepository.save(role);
    }

    public void deleteByRole(String roleName){
        roleCrudRepository.deleteByRole(roleName);
    }
}
