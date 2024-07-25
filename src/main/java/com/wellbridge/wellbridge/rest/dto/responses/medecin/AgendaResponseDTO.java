package com.wellbridge.wellbridge.rest.dto.responses.medecin;

import com.wellbridge.wellbridge.rest.dto.responses.patient.AppointmentResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AgendaResponseDTO {
    private Long id;
    private LocalDate date;
    private boolean morning;
    private boolean afternoon;
    private boolean evening;
    private Long doctorId;
    private List<AppointmentResponseDTO> appointments;

    // Getters and Setters
}