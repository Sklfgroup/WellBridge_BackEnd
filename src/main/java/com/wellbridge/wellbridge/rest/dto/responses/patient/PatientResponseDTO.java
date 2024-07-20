package com.wellbridge.wellbridge.rest.dto.responses.patient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientResponseDTO {
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String number;

    public PatientResponseDTO(AccountEntity patient) {
        this.uuid = patient.getUuid();
        this.firstname = patient.getFirstname();
        this.lastname = patient.getLastname();
        this.username = patient.getUsername();
        this.number = patient.getNumber();
    }
}
