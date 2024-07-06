package com.wellbridge.wellbridge.services;

import com.wellbridge.wellbridge.rest.dto.requests.patient.CreateSpecializationRequest;
import com.wellbridge.wellbridge.rest.dto.responses.patient.SpecializationResponse;

public interface SpecializationService {
    SpecializationResponse createSpecializationForAllPatients(CreateSpecializationRequest request);
}