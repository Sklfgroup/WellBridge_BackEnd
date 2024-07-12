package com.wellbridge.wellbridge.rest.controllers;


import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import com.wellbridge.wellbridge.rest.api.AgendaControllerApi;
import com.wellbridge.wellbridge.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController implements AgendaControllerApi {
    @Autowired
    private AgendaService agendaService;

    @Override
    public List<AgendaEntity> getAgendasByDoctor(@PathVariable Long doctorId) {
        return agendaService.getAgendasByDoctorId(doctorId);
    }

    @Override
    public AgendaEntity createAgenda(@RequestBody AgendaEntity agenda) {
        return agendaService.saveAgenda(agenda);
    }

    // Autres méthodes possibles (mise à jour, suppression, etc.)
}