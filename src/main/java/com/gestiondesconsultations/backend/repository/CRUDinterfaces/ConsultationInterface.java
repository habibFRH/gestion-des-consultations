package com.gestiondesconsultations.backend.repository.CRUDinterfaces;

import java.util.List;

import java.util.Optional;

import com.gestiondesconsultations.backend.model.Consultation;

public interface ConsultationInterface {
    //get
    List<Consultation> getAllConsultations();
    Optional<Consultation> getConsultationById(Integer id);
    void addConsultation(Consultation Consultation);

    //post
    boolean existsConsultationById(Integer id);

    //delete 
    void deleteConsultation(Integer id);

    //update
    Consultation getOneConsultationById(Integer id);
    void updateConsultation(Consultation consultation);
}
