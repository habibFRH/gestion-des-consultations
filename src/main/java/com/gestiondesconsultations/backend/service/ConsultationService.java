package com.gestiondesconsultations.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestiondesconsultations.backend.exception.ResourceNotFoundException;
import com.gestiondesconsultations.backend.exception.SuccessfullRequestException;
import com.gestiondesconsultations.backend.exception.ValidationRequestException;
import com.gestiondesconsultations.backend.model.Consultation;
import com.gestiondesconsultations.backend.model.records.ConsultationRecord;
import com.gestiondesconsultations.backend.repository.CRUDinterfaces.ConsultationInterface;

@Service
public class ConsultationService {
    private ConsultationInterface consultationInterface;

    public ConsultationService(ConsultationInterface consultationInterface) {
        this.consultationInterface = consultationInterface;
    }

    //get method
    public List<Consultation> getAllConsultations() {
        return Optional.ofNullable(
            consultationInterface.getAllConsultations())
            .orElseThrow(
                ()-> new ResourceNotFoundException("the database is empty")
            )
            ;
    }

    public Optional<Consultation> getOneConsultation(Integer id) {
        return Optional.ofNullable(
            consultationInterface.getConsultationById(id)
            .orElseThrow(
                () -> new ResourceNotFoundException("Consultation not found")
            )
        );
    }

    //post method
    public void addConsultation(ConsultationRecord consultationRecord) {
        Consultation consultation = new Consultation(consultationRecord.medecinId(), consultationRecord.patientId(),
                consultationRecord.description(), consultationRecord.date());
        consultationInterface.addConsultation(consultation);
        throw new SuccessfullRequestException("Consultation added successfully");
    }

    //delete method
    public void deleteConsultation(Integer id) {
        if (consultationInterface.existsConsultationById(id)) {
            throw new ResourceNotFoundException(String.format("Consultaion with id %d does not exist", id));
        }
        consultationInterface.deleteConsultation(id);
        throw new SuccessfullRequestException("Consultation deleted successfully !");
    }

    //update method
    public void updateConsultation(Integer id, ConsultationRecord consultationRecord) {
        if (!consultationInterface.existsConsultationById(id)) {
            throw new ResourceNotFoundException(String.format("Consultation with id %d does not exist", id));
        }
        Consultation consultation = consultationInterface.getOneConsultationById(id);
        boolean changes = false ; 

        if(consultationRecord.medecinId() != null && consultationRecord.medecinId() !=consultation.getMedecinId()){
            changes = true ; 
            consultation.setMedecinId(consultationRecord.medecinId());
        }

        if(consultationRecord.patientId() != null && consultationRecord.patientId() !=consultation.getPatientId()){
            changes = true ; 
            consultation.setPatientId(consultationRecord.patientId());
        }

        if(consultationRecord.description() != null && !consultationRecord.description().equals(consultation.getDescription())){
            changes = true ; 
            consultation.setDescription(consultationRecord.description());
        }

        if(consultationRecord.date() != null && !consultationRecord.date().equals(consultation.getDate())){
            changes = true ; 
            consultation.setDate(consultationRecord.date());
        }

        if(!changes){
            throw new ValidationRequestException("no data changes found");
        }

        consultationInterface.updateConsultation(consultation);
        throw new SuccessfullRequestException("Consultation updated successfully");
    }

}
