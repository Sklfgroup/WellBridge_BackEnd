package com.wellbridge.wellbridge.rest.dto.requests.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record CreatePatientRequest(
        @NotBlank(message = "First name is required")
        @JsonProperty("firstname") String firstname,

        @NotBlank(message = "Last name is required")
        @JsonProperty("lastname") String lastname,

        @NotBlank(message = "Username is required")
        @JsonProperty("username") String username,



        @NotBlank(message = "BloodGroup is require")
        @JsonProperty("BloodGroup") String BloodGroup,

        @NotBlank(message = "BloodGroup is not require")
        @JsonProperty("Sexe") String Sexe,

        @NotBlank(message = "BloodGroup is not require")
        @JsonProperty("City") String City,

        @NotBlank(message = "BloodGroup is not require")
        @JsonProperty("Profession") String Profession,

        @NotBlank(message = "BloodGroup is not require")
        @JsonProperty("Alcohol") String Alcohol,

        @NotBlank(message = "BloodGroup is not require")
        @JsonProperty("Smoking") String Smoking,

        @NotBlank(message = "Number is required")
        @JsonProperty("number") String number,

        @NotNull(message = "Date of birth is required")
        @JsonProperty("dateOfBirth") String dateOfBirth,

        @NotBlank(message = "Address is required")
        @JsonProperty("adresse") String adresse,

        @NotNull(message = "function is required")
        @JsonProperty(value = "userRole", required = true)
        UserRole userRole
) {
    public AccountEntity toEntity() {
        AccountEntity entity = new AccountEntity();
        entity.setFirstname(firstname);
        entity.setLastname(lastname);
        entity.setUsername(username);
        entity.setNumber(number);
        entity.setDateOfBirth(dateOfBirth);
        entity.setAlcohol(Alcohol);
        entity.setSexe(Sexe);
        entity.setCity(City);
        entity.setProfession(Profession);
        entity.setSmoking(Smoking);
        entity.setAdresse(adresse);
        entity.setBloodGroup(BloodGroup);
        entity.setUserRole(userRole);

        // Création de l'information médicale
        MedicalInfo medicalInfo = new MedicalInfo();
        entity.setMedicalInfo(medicalInfo);
        medicalInfo.setAccount(entity);
        return entity;
    }
}
