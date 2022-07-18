package com.design.patterns.project.repository;

import com.design.patterns.project.models.User;
import com.design.patterns.project.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> findAll(){
        return userCrudRepository.findAll();
    }

    public User findByUsername(String username){
        return userCrudRepository.findByUsername(username);
    }

    public void save(User user){
        userCrudRepository.save(user);
    }

    public void deleteByUsername(String username){
        userCrudRepository.deleteByUsername(username);
    }
}
