package com.gestiondesconsultations.backend.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Doctor {
    @Id
    @SequenceGenerator(sequenceName = "doctor_seq_id",name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq_id")
    private Integer id; 
    private String name ; 
    private String password;

    public Doctor(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Doctor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
