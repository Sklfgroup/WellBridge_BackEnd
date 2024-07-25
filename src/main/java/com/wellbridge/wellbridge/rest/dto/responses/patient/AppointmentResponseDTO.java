package com.wellbridge.wellbridge.rest.dto.responses.patient;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
public class AppointmentResponseDTO {
    private Long id;
    private LocalTime time;
    private String status;
    private Long agendaId;
    private Long patientId;

    // Getters and Setters
}