package com.gestiondesconsultations.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cons_id_seq")
    @SequenceGenerator(name = "Con_id", sequenceName = "cons_id_seq")
    private Integer id ; 
    private Integer patientId; 
    private Integer medecinId;
    private String date;
    private String description;

    public Consultation(Integer patientId, Integer medecinId, String date, String description) {
        this.patientId = patientId;
        this.medecinId = medecinId;
        this.date = date;
        this.description = description;
    }

    public Consultation(Integer medecinId, String date, String description) {
        this.medecinId = medecinId;
        this.date = date;
        this.description = description;
    }

    public Consultation() {
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPatientId() {
        return patientId;
    }
    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
    public Integer getMedecinId() {
        return medecinId;
    }
    public void setMedecinId(Integer medecinId) {
        this.medecinId = medecinId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    } 

    
}
