package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table
public class Admin {
    @Id
    @SequenceGenerator(
            name = "admin_sequence",
            sequenceName = "admin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "admin_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String password;
    private LocalDate dob;
    private boolean gender;
    @Transient
    private Integer age;
    public Admin(Long id,
                 String name,
                 String email,
                 String password,
                 LocalDate dob,
                 boolean gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }

    public Admin(String name,
                 String email,
                 String password,
                 LocalDate dob,
                 boolean gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
    }

    public Admin() {

    }
    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
