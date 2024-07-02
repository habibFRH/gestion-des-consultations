package com.gestiondesconsultations.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gestiondesconsultations.backend.model.Doctor;
import com.gestiondesconsultations.backend.repository.CRUDinterfaces.DoctorInterface;
import com.gestiondesconsultations.backend.repository.JPAinterfaces.DoctorJPA;

@Repository
public class DoctorDAO implements DoctorInterface {
    @Autowired
    private DoctorJPA doctorJPA;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorJPA.findAll();
    }

    @Override
    public Optional<Doctor> getDoctorById(Integer id) {
        return doctorJPA.findById(id);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorJPA.save(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorJPA.save(doctor);
    }

    @Override
    public void deleteDoctor(Integer id) {
        doctorJPA.deleteById(id);
    }

    @Override
    public boolean existsDoctorById(Integer id) {
        return doctorJPA.existsById(id);
    }

    @Override
    public Doctor getByIdDoctor(Integer id) {
        return (Doctor) doctorJPA.getReferenceById(id);
    }

    @Override
    public boolean existsDoctorByName(String name) {
        return doctorJPA.existsDoctorByName(name);
    }

}
