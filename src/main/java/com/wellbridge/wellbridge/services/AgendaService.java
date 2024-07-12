package com.wellbridge.wellbridge.services;


import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;


import java.util.List;

public interface AgendaService {
    List<AgendaEntity> getAgendasByDoctorId(Long doctorId);
    AgendaEntity saveAgenda(AgendaEntity agenda);
}