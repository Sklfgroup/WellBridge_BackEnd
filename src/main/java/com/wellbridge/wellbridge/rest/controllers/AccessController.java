package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.rest.api.AccessControllerApi;
import com.wellbridge.wellbridge.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/access")
public class AccessController implements AccessControllerApi {

    @Autowired
    private AccessService accessService;

    @Override
    public ResponseEntity<Void> requestAccess(String medecinUuid, String medicalInfoUuid) {
        accessService.requestAccess(medecinUuid, medicalInfoUuid);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> respondToAccessRequest(String medecinUuid, String medicalInfoUuid, boolean isApproved) {
        accessService.respondToAccessRequest(medecinUuid, medicalInfoUuid, isApproved);
        return ResponseEntity.ok().build();
    }
}
