package com.wellbridge.wellbridge.services;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;

public interface AccessService {
    void requestAccess(String medecinUuid, String medicalInfoUuid);
    void acceptAccessRequest(Long accessRequestId);
    void rejectAccessRequest(Long accessRequestId);
}