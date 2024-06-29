package com.gestiondesconsultations.backend.repository.CRUDinterfaces;

import java.util.List;

import java.util.Optional;

import com.gestiondesconsultations.backend.model.Doctor;

public interface DoctorInterface {
    List<Doctor> getAllDoctors();
    Optional<Doctor> getDoctorById(Integer id);
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(Integer id);
    boolean existsDoctorById(Integer id);
    Doctor getByIdDoctor(Integer id);
    boolean existsDoctorByName(String name);
}


