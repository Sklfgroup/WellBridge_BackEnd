package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.patient.AccessRequest;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfo;
import com.wellbridge.wellbridge.dao.entities.repository.AccountRepository;
import com.wellbridge.wellbridge.dao.entities.repository.AccessRequestRepository;
import com.wellbridge.wellbridge.dao.entities.repository.MedicalInfoRepository;
import com.wellbridge.wellbridge.services.AccessService;
import com.wellbridge.wellbridge.services.Notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MedicalInfoRepository medicalInfoRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private AccessRequestRepository accessRequestRepository;

    @Override
    public void requestAccess(String medecinUuid, String medicalInfoUuid) {
        Optional<AccountEntity> medecinOpt = accountRepository.findByUuid(medecinUuid);
        Optional<MedicalInfo> medicalInfoOpt = medicalInfoRepository.findByUuid(medicalInfoUuid);

        if (medecinOpt.isPresent() && medicalInfoOpt.isPresent()) {
            AccountEntity medecin = medecinOpt.get();
            MedicalInfo medicalInfo = medicalInfoOpt.get();
            AccountEntity patient = medicalInfo.getAccount();

            AccessRequest accessRequest = new AccessRequest();
            accessRequest.setMedecin(medecin);
            accessRequest.setPatient(patient);
            accessRequestRepository.save(accessRequest);

            notificationService.sendAccessRequestNotification(patient, medecin);
        } else {
            // Handle the case where medecin or medicalInfo is not found
            // You can throw an exception or handle it appropriately
            throw new RuntimeException("Medecin or MedicalInfo not found");
        }
    }

    @Override
    public void respondToAccessRequest(String medecinUuid, String medicalInfoUuid, boolean isApproved) {
        Optional<AccountEntity> medecinOpt = accountRepository.findByUuid(medecinUuid);
        Optional<MedicalInfo> medicalInfoOpt = medicalInfoRepository.findByUuid(medicalInfoUuid);

        if (medecinOpt.isPresent() && medicalInfoOpt.isPresent()) {
            AccountEntity medecin = medecinOpt.get();
            MedicalInfo medicalInfo = medicalInfoOpt.get();
            AccountEntity patient = medicalInfo.getAccount();

            if (isApproved) {
                // Add medecin to patient's medecins list and patient to medecin's patients list
                medecin.getPatients().add(patient);
                patient.getMedecins().add(medecin);
                accountRepository.save(medecin);
                accountRepository.save(patient);
            }

            notificationService.sendAccessResponseNotification(medecin, isApproved);
        } else {
            // Handle the case where medecin or medicalInfo is not found
            // You can throw an exception or handle it appropriately
            throw new RuntimeException("Medecin or MedicalInfo not found");
        }
    }
}
