package com.design.patterns.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity()
@Table(name = "t_employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer id;

    @NotNull(message = "El dni es requerido")
    @Column(name = "emp_dni",length = 10,unique = true)
    @Size(min = 10, max = 10, message = "El dni debe tener 10 digitos")
    @Pattern(regexp = "^[0-9]{10}$", message = "El dni debe tener 10 digitos")
    private String dni;

    @NotNull(message = "El nombre es requerido")
    @Column(name = "emp_first_name")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El nombre solo debe contener letras")
    private String firstName;

    @NotNull(message = "El apellido es requerido")
    @Column(name = "emp_last_name")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "El nombre solo debe contener letras")
    private String lastName;

    @NotNull(message = "El email es requerido")
    @Column(name = "emp_email")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "El email no es valido")
    private String email;

    @Column(name = "emp_date_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateBirth;

    @Column(name = "emp_address")
    private String address;

    @Column(name = "emp_phone_number")
    @Pattern(regexp = "^[0-9]{10}$", message = "El numero de telefono debe tener 10 digitos")
    private String phone;

    @Column(name = "emp_status_vac")
    private Boolean vaccineStatus;

    /*
    @JsonManagedReference
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Dose> doses;
    */

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_usr_id", referencedColumnName = "usr_id")
    private User user;
}
