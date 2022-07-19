package com.design.patterns.project.models;

import com.design.patterns.project.constants.VaccineEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_doses")
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dose_id")
    private Integer id;

    @Column(name = "dose_number")
    private Integer doseNumber;

    @Column(name = "dose_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date doseDate;

    @Column(name ="dose_vaccine")
    @Enumerated(EnumType.STRING)
    private VaccineEnum vaccineEnum;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "dose_emp_id", referencedColumnName = "emp_id")
    private Employee employee;
}
