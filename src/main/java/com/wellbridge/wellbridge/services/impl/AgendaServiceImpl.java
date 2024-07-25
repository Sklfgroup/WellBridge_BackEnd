package com.wellbridge.wellbridge.services.impl;

import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import com.wellbridge.wellbridge.dao.entities.repository.AgendaRepository;
import com.wellbridge.wellbridge.rest.dto.requests.medecin.AgendaRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.medecin.AgendaResponseDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AppointmentResponseDTO;
import com.wellbridge.wellbridge.services.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;

    @Override
    public List<AgendaResponseDTO> getAgendasByDoctorId(Long doctorId) {
        return agendaRepository.findByDoctorId(doctorId).stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public AgendaResponseDTO saveAgenda(AgendaRequestDTO agendaRequestDTO) {
        AgendaEntity agendaEntity = new AgendaEntity();
        agendaEntity.setDate(agendaRequestDTO.getDate());
        agendaEntity.setMorning(agendaRequestDTO.isMorning());
        agendaEntity.setAfternoon(agendaRequestDTO.isAfternoon());
        agendaEntity.setEvening(agendaRequestDTO.isEvening());
        AccountEntity doctor = new AccountEntity(); // Assurez-vous de récupérer le docteur réel ici
        doctor.setId(agendaRequestDTO.getDoctorId());
        agendaEntity.setDoctor(doctor);

        agendaEntity = agendaRepository.save(agendaEntity);
        return convertToResponseDTO(agendaEntity);
    }

    private AgendaResponseDTO convertToResponseDTO(AgendaEntity agendaEntity) {
        AgendaResponseDTO agendaResponseDTO = new AgendaResponseDTO();
        agendaResponseDTO.setId(agendaEntity.getId());
        agendaResponseDTO.setDate(agendaEntity.getDate());
        agendaResponseDTO.setMorning(agendaEntity.isMorning());
        agendaResponseDTO.setAfternoon(agendaEntity.isAfternoon());
        agendaResponseDTO.setEvening(agendaEntity.isEvening());
        agendaResponseDTO.setDoctorId(agendaEntity.getDoctor().getId());

        if (agendaEntity.getAppointments() != null) {
            agendaResponseDTO.setAppointments(agendaEntity.getAppointments().stream()
                    .map(appointment -> {
                        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
                        // set other fields...
                        return appointmentResponseDTO;
                    }).collect(Collectors.toList()));
        } else {
            agendaResponseDTO.setAppointments(new ArrayList<>());
        }

        return agendaResponseDTO;
    }

}