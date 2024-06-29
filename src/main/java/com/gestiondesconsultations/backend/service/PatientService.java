package com.gestiondesconsultations.backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.gestiondesconsultations.backend.exception.DuplicateResourceException;
import com.gestiondesconsultations.backend.exception.ResourceNotFoundException;
import com.gestiondesconsultations.backend.exception.SuccessfullRequestException;
import com.gestiondesconsultations.backend.exception.ValidationRequestException;
import com.gestiondesconsultations.backend.model.Patient;
import com.gestiondesconsultations.backend.model.records.PatientRecord;
import com.gestiondesconsultations.backend.repository.CRUDinterfaces.PatientInterface;

@Service
public class PatientService {
    private PatientInterface patientInterface; 

    public PatientService(PatientInterface patientInterface){
        this.patientInterface = patientInterface;
    }

    //get method
    public List<Patient> getAllPatients(){
        return Optional.ofNullable(patientInterface.getAllPatients())
        .orElseThrow(
            ()-> new ResourceNotFoundException("database is empty")
        );
    }

    public Optional<Patient> getonePatient(Integer id){
        if(!patientInterface.existsPatientById(id)){
            throw new ResourceNotFoundException(String.format("patient with id %d not found", id));
        }
        return patientInterface.getPatientById(id);
    }

    //post method 
    public void addPatient(PatientRecord patientRecord){
        if(!patientInterface.existsPatientByName(patientRecord.name())){
            throw new DuplicateResourceException("patient already exists");
        }
        Patient patient = new Patient(
            patientRecord.name(),
            patientRecord.age()
        );
        patientInterface.addPatient(patient);
        throw new SuccessfullRequestException("Patient added successfully");
    }

    //delete method
    public void deletePatient(Integer id){
        if(!patientInterface.existsPatientById(id)){
            throw new ResourceNotFoundException(String.format("patient with id %d not found", id));
        }
        patientInterface.deletePatient(id);
        throw new SuccessfullRequestException("Patient deleted successfully");
    }

    //put method
    public void updatePatient(Integer id, PatientRecord patientRecord){
        if(!patientInterface.existsPatientById(id)){
            throw new ResourceNotFoundException(String.format("patient with id %d not found", id));
        }

        Patient patient = patientInterface.getByIdPatient(id);
        boolean changes = false ; 

        if(patientRecord.name() != null && !patient.getName().equals(patientRecord.name())){
            changes = true ;
            patient.setName(patientRecord.name());
        }

        if(patientRecord.age() != null && patient.getAge() !=patientRecord.age()){
            changes = true ;
            patient.setAge(patientRecord.age());
        }

        if(!changes){
            throw new ValidationRequestException("no data changes found");
        }

        patientInterface.updatePatient(patient);
        throw new SuccessfullRequestException("Patient updated successfully");
    }

}
