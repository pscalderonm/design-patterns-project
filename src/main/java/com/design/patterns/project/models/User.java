package com.design.patterns.project.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Integer id;

    @Column(name = "usr_username", unique = true)
    private String username;

    @Column(name = "usr_password")
    private String password;

    @OneToOne
    @JoinColumn(name = "usr_role_id", referencedColumnName = "role_id")
    private Role role;

}
