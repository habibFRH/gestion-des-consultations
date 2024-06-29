package com.gestiondesconsultations.backend.repository.JPAinterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("rawtypes")
public interface DoctorJPA extends JpaRepository{
    Boolean existsDoctorByName(String name);
} 