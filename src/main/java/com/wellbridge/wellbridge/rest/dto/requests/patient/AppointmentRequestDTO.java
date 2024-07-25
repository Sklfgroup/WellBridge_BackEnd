package com.wellbridge.wellbridge.rest.dto.requests.patient;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class AppointmentRequestDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime time;
    private String status;
    private Long agendaId;
    private Long patientId;

    // Getters and Setters
}