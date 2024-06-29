package com.gestiondesconsultations.backend.model.records;

public record ConsultationRecord(
        Integer patientId,
        Integer medecinId,
        String date,
        String description) {

}
