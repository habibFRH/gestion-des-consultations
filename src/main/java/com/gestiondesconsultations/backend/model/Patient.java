package com.gestiondesconsultations.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Patient {
    @Id
    @SequenceGenerator(name = "patient_id", sequenceName = "patient_seq_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq_id")
    private Integer id; 
    private String name ; 
    private Integer age ;

    public Patient(String name, Integer age) {
        this.name = name;
        this.age = age;
    } 

    public Patient() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    } 

    
}
