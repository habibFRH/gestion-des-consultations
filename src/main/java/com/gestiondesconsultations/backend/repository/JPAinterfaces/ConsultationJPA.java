package com.gestiondesconsultations.backend.repository.JPAinterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondesconsultations.backend.model.Consultation;

public interface ConsultationJPA extends JpaRepository<Consultation,Integer> {
    
} 
