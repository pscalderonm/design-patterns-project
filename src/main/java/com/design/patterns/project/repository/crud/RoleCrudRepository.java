package com.design.patterns.project.repository.crud;

import com.design.patterns.project.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RoleCrudRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRole(String roleName);
    @Transactional
    void deleteByRole(String role);
}
