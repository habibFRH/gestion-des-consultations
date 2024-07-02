package com.gestiondesconsultations.backend.repository.JPAinterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondesconsultations.backend.model.Patient;

public interface PatientJPA extends JpaRepository<Patient, Integer> {
    boolean existsByName(String name);
}
