package com.wellbridge.wellbridge.rest.dto.responses.patient;

import com.wellbridge.wellbridge.dao.entities.patient.AccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccessResponse {
    private String status;
    private String message;
}
