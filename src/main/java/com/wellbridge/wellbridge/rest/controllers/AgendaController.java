package com.wellbridge.wellbridge.rest.controllers;


import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import com.wellbridge.wellbridge.rest.api.AgendaControllerApi;
import com.wellbridge.wellbridge.rest.dto.requests.medecin.AgendaRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.medecin.AgendaResponseDTO;
import com.wellbridge.wellbridge.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
@CrossOrigin
public class AgendaController implements AgendaControllerApi {
    @Autowired
    private AgendaService agendaService;

    @Override
    public List<AgendaResponseDTO> getAgendasByDoctor(@PathVariable Long doctorId) {
        return agendaService.getAgendasByDoctorId(doctorId);
    }

    @Override
    public AgendaResponseDTO createAgenda(@RequestBody AgendaRequestDTO agendaRequestDTO) {
        return agendaService.saveAgenda(agendaRequestDTO);
    }

    // Autres méthodes possibles (mise à jour, suppression, etc.)
}