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

import com.gestiondesconsultations.backend.model.Consultation;
import com.gestiondesconsultations.backend.model.records.ConsultationRecord;
import com.gestiondesconsultations.backend.service.ConsultationService;

@RestController
@RequestMapping("Consultation")
public class ConsultationController {
    private ConsultationService consultationService; 

    public ConsultationController(ConsultationService consultationService){
        this.consultationService = consultationService; 
    }

    @GetMapping("allconsultations")
    public List<Consultation> getAllConsultations(){
        return consultationService.getAllConsultations();
    }

    @GetMapping("consultation/{id}")
    public Optional<Consultation> getConsultationById(@PathVariable("id") Integer id){
        return consultationService.getOneConsultation(id);
    }

    @PostMapping
    public void addConsultation(ConsultationRecord consultationRecord){
        consultationService.addConsultation(consultationRecord);
    }

    @DeleteMapping("doctor/{id}")
    public void deleteConsultation(@PathVariable("id") Integer id){
        consultationService.deleteConsultation(id);
    }

    @PutMapping("consultation/{id}")
    public void updateConsultation(@PathVariable("id")Integer id ,ConsultationRecord consultationRecord){
        consultationService.updateConsultation(id,consultationRecord);
    }
}
