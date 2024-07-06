package com.wellbridge.wellbridge.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface AccessControllerApi {
    @PostMapping("/request")
    ResponseEntity<Void> requestAccess(@RequestParam String medecinUuid, @RequestParam String medicalInfoUuid);

    @PostMapping("/respond")
    ResponseEntity<Void> respondToAccessRequest(@RequestParam String medecinUuid, @RequestParam String medicalInfoUuid, @RequestParam boolean isApproved);
}