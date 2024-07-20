package com.wellbridge.wellbridge.services;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.requests.account.UpdateAccountRequest;
import com.wellbridge.wellbridge.rest.dto.responses.medecin.MedecinResponseDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.PatientResponseDTO;

import java.util.List;

import java.util.Optional;


public interface AccountService {
    AccountEntity createAdminAccount(AccountEntity adminAccount);
    AccountEntity createPatientAccount(AccountEntity patientAccount);
    AccountEntity createMedecinAccount(AccountEntity medecinAccount);
    AccountEntity updateAccount(String uuid, UpdateAccountRequest request);
    AccountEntity getAccountByUuid(String uuid);
    AccountEntity getAccountByUsername(String username);
    List<AccountEntity> getAllAccounts();
    List<AccountEntity> getAccountsByRole(UserRole role);
    AccountEntity authenticate(String username, String password);
    List<MedecinResponseDTO> getMedecinsOfPatient(String patientUuid);
    List<PatientResponseDTO> getPatientsOfMedecin(String medecinUuid);

}
