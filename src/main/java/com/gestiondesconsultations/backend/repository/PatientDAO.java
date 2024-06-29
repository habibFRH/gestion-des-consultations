package com.gestiondesconsultations.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gestiondesconsultations.backend.model.Patient;
import com.gestiondesconsultations.backend.repository.CRUDinterfaces.PatientInterface;
import com.gestiondesconsultations.backend.repository.JPAinterfaces.PatientJPA;

@Repository
@SuppressWarnings("unchecked")
public class PatientDAO implements PatientInterface {
    @Autowired
    private PatientJPA patientJPA;

    @Override
    public List<Patient> getAllPatients() {
        return patientJPA.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Integer id) {
        return patientJPA.findById(id);
    }

    @Override
    public void addPatient(Patient patient) {
        patientJPA.save(patient);
    }

    @Override
    public void updatePatient(Patient Patient) {
        patientJPA.save(Patient);
    }

    @Override
    public void deletePatient(Integer id) {
        patientJPA.deleteById(id);
    }

    @Override
    public boolean existsPatientById(Integer id) {
        return patientJPA.existsById(id);
    }

    @Override
    public Patient getByIdPatient(Integer id) {
        return (Patient) patientJPA.getReferenceById(id);
    }

    @Override
    public boolean existsPatientByName(String name) {
        return patientJPA.existsByName(name);
    }
    
}
