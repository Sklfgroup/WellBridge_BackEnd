package com.wellbridge.wellbridge.dao.entities.repository;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.patient.AccessRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    Optional<AccessRequest> findByMedecinAndPatient(AccountEntity medecin, AccountEntity patient);
}