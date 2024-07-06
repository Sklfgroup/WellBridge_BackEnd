package com.wellbridge.wellbridge.rest.controllers;

import com.wellbridge.wellbridge.rest.api.SpecializationControllerApi;
import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateSpecializationRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.SpecializationResponse;
import com.wellbridge.wellbridge.services.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/specializations")
public class SpecializationController implements SpecializationControllerApi {

    private final SpecializationService specializationService;

    @Autowired
    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @Override
    @PreAuthorize("hasRole('SUPERADMINISTRATOR')")
    public ResponseEntity<SpecializationResponse> createSpecialization(CreateSpecializationRequest request) {
        SpecializationResponse response = specializationService.createSpecializationForAllPatients(request);
        return ResponseEntity.ok(response);
    }
}
