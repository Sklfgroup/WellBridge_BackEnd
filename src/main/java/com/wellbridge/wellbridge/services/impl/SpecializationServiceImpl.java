package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.account.UserRole;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfo;
import com.wellbridge.wellbridge.dao.entities.patient.Specialization;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.dao.entities.repository.SpecializationRepository;
import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateSpecializationRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.SpecializationResponse;
import com.wellbridge.wellbridge.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final AccountRepository accountRepository;
    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationServiceImpl(AccountRepository accountRepository, SpecializationRepository specializationRepository) {
        this.accountRepository = accountRepository;
        this.specializationRepository = specializationRepository;
    }

    @Override
    public SpecializationResponse createSpecializationForAllPatients(CreateSpecializationRequest request) {
        List<AccountEntity> patients = accountRepository.findByUserRole(UserRole.PATIENT);
        Specialization specialization = new Specialization();
        specialization.setName(request.getName());
        specialization.setImage(request.getImage());

        for (AccountEntity patient : patients) {
            MedicalInfo medicalInfo = patient.getMedicalInfo();
            if (medicalInfo != null) {
                Specialization patientSpecialization = new Specialization();
                patientSpecialization.setName(request.getName());
                patientSpecialization.setImage(request.getImage());
                patientSpecialization.setMedicalInfo(medicalInfo);
                specializationRepository.save(patientSpecialization);
            }
        }

        SpecializationResponse response = new SpecializationResponse();
        response.setId(specialization.getId());
        response.setName(specialization.getName());
        response.setImage(specialization.getImage());
        return response;
    }
}