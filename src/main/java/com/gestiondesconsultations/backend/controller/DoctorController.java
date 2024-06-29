package com.gestiondesconsultations.backend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.gestiondesconsultations.backend.model.Doctor;
import com.gestiondesconsultations.backend.model.records.DoctorRecord;
import com.gestiondesconsultations.backend.service.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    private DoctorService doctorService; 

    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @GetMapping("alldoctors")
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("doctor/{id}")
    public Optional<Doctor> getOneDoctor(@PathVariable("id")Integer id){
        return doctorService.getOneDoctor(id);
    }

    @PostMapping
    public void addDoctor(DoctorRecord doctorRecord){
        doctorService.addDoctor(doctorRecord);
    }

    @DeleteMapping("doctor/{id}")
    public void deleteDoctor(@PathVariable("id") Integer id){
        doctorService.deleteDoctor(id);
    }

    @PutMapping("doctor/{id}")
    public void updateDoctor(@PathVariable("id")Integer id,DoctorRecord doctorRecord){
        doctorService.updateDoctor(id,doctorRecord);
    }
}
