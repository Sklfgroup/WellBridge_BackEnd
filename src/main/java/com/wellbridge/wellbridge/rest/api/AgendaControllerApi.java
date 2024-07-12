package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface AgendaControllerApi {
    @GetMapping("/doctor/{doctorId}")
    List<AgendaEntity> getAgendasByDoctor(@PathVariable Long doctorId);

    @PostMapping
    AgendaEntity createAgenda(@RequestBody AgendaEntity agenda);
}
