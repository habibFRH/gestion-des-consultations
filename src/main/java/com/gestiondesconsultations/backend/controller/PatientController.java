package com.gestiondesconsultations.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestiondesconsultations.backend.model.Patient;
import com.gestiondesconsultations.backend.model.records.PatientRecord;
import com.gestiondesconsultations.backend.service.PatientService;

@RestController
@RequestMapping("patient")
public class PatientController {
    private PatientService patientService; 

    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("allpatient")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatients();
    }

    @GetMapping("patient/{id}")
    public Optional<Patient> getPatient(Integer id){
        return patientService.getonePatient(id);
    }

    @PostMapping
    public void addPatient(PatientRecord patientRecord){
        patientService.addPatient(patientRecord);
    }

    @DeleteMapping("patient/{id}")
    public void deletePatient(@PathVariable("id") Integer id){
        patientService.deletePatient(id);
    }

    @PutMapping("doctor/{id}")
    public void updatePatient(@PathVariable Integer id,PatientRecord patientrRecord){
        patientService.updatePatient(id,patientrRecord);
    }
}
