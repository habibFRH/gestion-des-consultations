package com.gestiondesconsultations.backend.service;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.gestiondesconsultations.backend.exception.DuplicateResourceException;
import com.gestiondesconsultations.backend.exception.ResourceNotFoundException;
import com.gestiondesconsultations.backend.exception.SuccessfullRequestException;
import com.gestiondesconsultations.backend.exception.ValidationRequestException;
import com.gestiondesconsultations.backend.model.Doctor;
import com.gestiondesconsultations.backend.model.records.DoctorRecord;
import com.gestiondesconsultations.backend.repository.CRUDinterfaces.DoctorInterface;

@Service
public class DoctorService {

    private DoctorInterface doctorInterface; 

    public DoctorService(DoctorInterface doctorInterface){
        this.doctorInterface = doctorInterface;
    }


    //get method
    public List<Doctor> getAllDoctors(){
        return doctorInterface.getAllDoctors();
    }
    
    public Optional<Doctor> getOneDoctor(Integer id){
        return Optional.ofNullable(
            doctorInterface.getDoctorById(id)
            .orElseThrow(
                ()-> new ResourceNotFoundException("Doctor not found")
            )
        );
    }

    //post method
    public void addDoctor(DoctorRecord doctorRecord){
        if(doctorInterface.existsDoctorByName(doctorRecord.name())){
            throw new DuplicateResourceException("Doctor already exists");
        }
        Doctor doctor = new Doctor(doctorRecord.name(), doctorRecord.password());
        doctorInterface.addDoctor(doctor);
        throw new SuccessfullRequestException("Doctor added successfully");
    }

    //delete method 
    public void deleteDoctor(Integer id){
        if(!doctorInterface.existsDoctorById(id)){
            throw new ResourceNotFoundException("Doctor not found");
        }
        doctorInterface.deleteDoctor(id);
        throw new SuccessfullRequestException("Doctor deleted successfully");
    }

    //update method
    public void updateDoctor(Integer id, DoctorRecord doctorRecord){
        if(!doctorInterface.existsDoctorById(id)){
            throw new ResourceNotFoundException("Doctor not found");
        }
        Doctor doctor = doctorInterface.getByIdDoctor(id);
        boolean changes = false;

        if(doctorRecord.name()!= null && !doctor.getName().equals(doctorRecord.name())){
            changes = true;
            doctor.setName(doctorRecord.name());
        }
        if(doctorRecord.password() != null && !doctor.getPassword().equals(doctorRecord.password())){
            changes = true;
            doctor.setPassword(doctorRecord.password());
        }

        if(!changes){
            throw new ValidationRequestException("no data changes found");
        }

        doctorInterface.updateDoctor(doctor);
        throw new SuccessfullRequestException("Doctor updated successfully");
    }

}
