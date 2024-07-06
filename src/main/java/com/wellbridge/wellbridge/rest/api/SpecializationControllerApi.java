package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateSpecializationRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.SpecializationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

public interface SpecializationControllerApi {

    @PostMapping("/create")
    ResponseEntity<SpecializationResponse> createSpecialization(@RequestBody CreateSpecializationRequest request);
}