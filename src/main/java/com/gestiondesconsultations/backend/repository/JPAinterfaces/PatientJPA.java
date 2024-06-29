package com.gestiondesconsultations.backend.repository.JPAinterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientJPA extends JpaRepository{
    boolean existsByName(String name);    
} 
