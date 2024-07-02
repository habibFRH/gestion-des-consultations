package com.gestiondesconsultations.backend.repository.JPAinterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiondesconsultations.backend.model.Doctor;

public interface DoctorJPA extends JpaRepository<Doctor,Integer>{
    Boolean existsDoctorByName(String name);
} 