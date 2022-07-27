package com.design.patterns.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/**","/roles/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/employees/").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/employees/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/employees/{employeeId}","/employees/{employeeDni}").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers(HttpMethod.PUT,"/employes/{employeeId}").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers(HttpMethod.DELETE,"/employes/{employeeId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/doses/").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/doses/").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers("/doses/{employee_dni}","/doses/{id}","/doses/{dose_id}").hasAnyRole("ADMIN","EMPLOYEE")
                .antMatchers("/test/**")
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }


    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
