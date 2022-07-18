package com.design.patterns.project.repository.crud;

import com.design.patterns.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserCrudRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
