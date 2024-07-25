package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import com.wellbridge.wellbridge.rest.dto.requests.medecin.AgendaRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.medecin.AgendaResponseDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface AgendaControllerApi {
    @GetMapping("/doctor/{doctorId}")
    List<AgendaResponseDTO> getAgendasByDoctor(@PathVariable Long doctorId);

    @PostMapping
    AgendaResponseDTO createAgenda(@RequestBody AgendaRequestDTO agendaRequestDTO);
}
