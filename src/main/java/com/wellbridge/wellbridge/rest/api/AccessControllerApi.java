package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateAccessRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface AccessControllerApi {
    @PostMapping("/request")
    ResponseEntity<Void> requestAccess(@RequestBody CreateAccessRequest createAccessRequest);


    @PostMapping("/accept/{accessRequestId}")
    ResponseEntity<Void> acceptAccessRequest(@PathVariable Long accessRequestId);

    @PostMapping("/reject/{accessRequestId}")
    ResponseEntity<Void> rejectAccessRequest(@PathVariable Long accessRequestId);


}