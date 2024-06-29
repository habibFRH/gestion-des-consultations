package com.gestiondesconsultations.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gestiondesconsultations.backend.model.Consultation;
import com.gestiondesconsultations.backend.repository.CRUDinterfaces.ConsultationInterface;
import com.gestiondesconsultations.backend.repository.JPAinterfaces.ConsultationJPA;

@Repository
@SuppressWarnings("unchecked")
public class ConsultationDAO implements ConsultationInterface {
    @Autowired
    private ConsultationJPA consultationJPA;

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationJPA.findAll();
    }

    @Override
    public Optional<Consultation> getConsultationById(Integer id) {
        return consultationJPA.findById(id);
    }

    @Override
    public void addConsultation(Consultation Consultation) {
        consultationJPA.save(Consultation);
    }

    @Override
    public void deleteConsultation(Integer id) {
        consultationJPA.deleteById(id);
    }

    @Override
    public boolean existsConsultationById(Integer id) {
        return consultationJPA.existsById(id);
    }

    @Override
    public void updateConsultation(Consultation Consultation) {
        consultationJPA.save(Consultation);
    }

    @Override
    public Consultation getOneConsultationById(Integer id) {
        return (Consultation) consultationJPA.getReferenceById(id);
    }

}
