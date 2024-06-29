package com.gestiondesconsultations.backend.repository.CRUDinterfaces;

import java.util.List;
import java.util.Optional;

import com.gestiondesconsultations.backend.model.Patient;

public interface PatientInterface {
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Integer id);
    void addPatient(Patient Patient);
    void updatePatient(Patient Patient);
    void deletePatient(Integer id);
    boolean existsPatientById(Integer id);
    Patient getByIdPatient(Integer id);
    boolean existsPatientByName(String name);
}
