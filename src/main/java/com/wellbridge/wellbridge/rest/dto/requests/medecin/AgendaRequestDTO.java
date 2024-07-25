package com.wellbridge.wellbridge.rest.dto.requests.medecin;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AgendaRequestDTO {
    private LocalDate date;
    private boolean morning;
    private boolean afternoon;
    private boolean evening;
    private Long doctorId;

    // Getters and Setters
}
