package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import com.wellbridge.wellbridge.dao.entities.repository.AgendaRepository;
import com.wellbridge.wellbridge.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public List<AgendaEntity> getAgendasByDoctorId(Long doctorId) {
        return agendaRepository.findByDoctorId(doctorId);
    }

    @Override
    public AgendaEntity saveAgenda(AgendaEntity agenda) {
        return agendaRepository.save(agenda);
    }
}