package com.wellbridge.wellbridge.services;


import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import com.wellbridge.wellbridge.rest.dto.requests.medecin.AgendaRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.medecin.AgendaResponseDTO;


import java.util.List;

public interface AgendaService {
    List<AgendaResponseDTO> getAgendasByDoctorId(Long doctorId);
    AgendaResponseDTO saveAgenda(AgendaRequestDTO agendaRequestDTO);
}