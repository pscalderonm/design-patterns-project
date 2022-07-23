package com.design.patterns.project;


import com.design.patterns.project.models.User;
import com.design.patterns.project.repository.DoseRepository;
import com.design.patterns.project.repository.RoleRepository;
import com.design.patterns.project.repository.UserRepository;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@SecurityScheme(
        name = "basicAuth", // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "basic",
        in = SecuritySchemeIn.HEADER
)
public class DesignPatternsProjectApplication implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DesignPatternsProjectApplication.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoseRepository doseRepository;



    public static void main(String[] args) {
        SpringApplication.run(DesignPatternsProjectApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin.123"));
        user.setRole(roleRepository.findByRole("ADMIN").get());
        userRepository.save(user);
        log.info("User admin created: {}",user);
    }

}
