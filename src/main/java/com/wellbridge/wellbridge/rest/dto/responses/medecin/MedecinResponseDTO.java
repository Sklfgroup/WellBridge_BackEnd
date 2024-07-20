package com.wellbridge.wellbridge.rest.dto.responses.medecin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedecinResponseDTO {
    private String uuid;
    private String firstname;
    private String lastname;
    private String username;
    private String number;

    public MedecinResponseDTO(AccountEntity medecin) {
        this.uuid = medecin.getUuid();
        this.firstname = medecin.getFirstname();
        this.lastname = medecin.getLastname();
        this.username = medecin.getUsername();
        this.number = medecin.getNumber();
    }
}
