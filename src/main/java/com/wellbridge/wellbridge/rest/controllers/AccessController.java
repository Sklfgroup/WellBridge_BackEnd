package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.rest.api.AccessControllerApi;
import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateAccessRequest;
import com.wellbridge.wellbridge.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/access")
@CrossOrigin(origins = "http://localhost")
public class AccessController implements AccessControllerApi {

    @Autowired
    private AccessService accessService;

    @Override
    public ResponseEntity<Void> requestAccess(CreateAccessRequest accessRequestDTO) {
        accessService.requestAccess(accessRequestDTO.getMedecinUuid(), accessRequestDTO.getMedicalInfoUuid());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> acceptAccessRequest(Long accessRequestId) {
        accessService.acceptAccessRequest(accessRequestId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> rejectAccessRequest(Long accessRequestId) {
        accessService.rejectAccessRequest(accessRequestId);
        return ResponseEntity.ok().build();
    }
}
