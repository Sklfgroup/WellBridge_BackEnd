package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateAccessRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface AccessControllerApi {
    @PostMapping("/request")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<Void> requestAccess(@RequestBody CreateAccessRequest createAccessRequest);


    @PostMapping("/respond")
    @CrossOrigin(origins = "http://localhost")
    ResponseEntity<Void> respondToAccessRequest(@RequestBody CreateAccessRequest createAccessRequest, @RequestParam boolean isApproved);
}