package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.rest.dto.requests.account.*;
import com.wellbridge.wellbridge.rest.dto.responses.account.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AccountApi {
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<ConnexionAccountResponse> authenticate(@RequestBody ConnexionAccountRequest request);

    @PutMapping("/update/{uuid}")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<AccountDataResponse> updateAccount(@PathVariable String uuid, @RequestBody UpdateAccountRequest request);

    @GetMapping("/uuid/{uuid}")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<AccountEntity> getAccountByUuid(@PathVariable String uuid);

    @GetMapping("/username/{username}")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<AccountEntity> getAccountByUsername(@PathVariable String username);

    @GetMapping
    ResponseEntity<List<AccountEntity>> getAllAccounts();

    @GetMapping("/role/{role}")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<List<AccountEntity>> getAccountsByRole(@PathVariable UserRole role);

    @PostMapping("/create-admin")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<AdminResponse> createAdmin(@RequestBody CreateAdminRequest adminRequest);

    @PostMapping("/create-patient")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<PatientResponse> createPatient(@RequestBody CreatePatientRequest patientRequest);

    @PostMapping("/create-medecin")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<MedecinResponse> createMedecin(@RequestBody CreateMedecinRequest medecinRequest);
}
