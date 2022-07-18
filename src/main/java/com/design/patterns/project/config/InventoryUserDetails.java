package com.design.patterns.project.config;

import com.design.patterns.project.models.User;
import com.design.patterns.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InventoryUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        String[] roles = new String[1];
        String password = user.getPassword();
        roles[0] = user.getRole().getRole().toUpperCase();
        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(password)
                .roles(roles)
                .build();
    }
}
