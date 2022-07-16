package com.design.patterns.project.repository.crud;

import com.design.patterns.project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
