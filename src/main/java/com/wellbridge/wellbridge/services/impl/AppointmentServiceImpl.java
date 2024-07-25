package com.wellbridge.wellbridge.services.impl;


import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentStatus;
import com.wellbridge.wellbridge.dao.entities.repository.AppointmentRepository;
import com.wellbridge.wellbridge.rest.dto.requests.patient.AppointmentRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AppointmentResponseDTO;
import com.wellbridge.wellbridge.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentResponseDTO saveAppointment(AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setTime(appointmentRequestDTO.getTime());
        appointmentEntity.setStatus(AppointmentStatus.valueOf(appointmentRequestDTO.getStatus()));
        // Set agenda and patient entities here using their IDs from the request DTO
        appointmentEntity = appointmentRepository.save(appointmentEntity);
        return convertToResponseDTO(appointmentEntity);
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId).stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public AppointmentResponseDTO findById(Long id) {
        Optional<AppointmentEntity> appointmentOpt = appointmentRepository.findById(id);
        return appointmentOpt.map(this::convertToResponseDTO).orElse(null);
    }

    @Override
    public AppointmentResponseDTO updateAppointmentStatus(Long appointmentId, String status) {
        Optional<AppointmentEntity> appointmentOpt = appointmentRepository.findById(appointmentId);
        if (appointmentOpt.isPresent()) {
            AppointmentEntity appointmentEntity = appointmentOpt.get();
            appointmentEntity.setStatus(AppointmentStatus.valueOf(status));
            appointmentEntity = appointmentRepository.save(appointmentEntity);
            return convertToResponseDTO(appointmentEntity);
        }
        // Gérer le cas où le rendez-vous n'existe pas
        return null;
    }

    private AppointmentResponseDTO convertToResponseDTO(AppointmentEntity appointmentEntity) {
        AppointmentResponseDTO dto = new AppointmentResponseDTO();
        dto.setId(appointmentEntity.getId());
        dto.setTime(appointmentEntity.getTime());
        dto.setStatus(appointmentEntity.getStatus().name());
        dto.setAgendaId(appointmentEntity.getAgenda().getId());
        dto.setPatientId(appointmentEntity.getPatient().getId());
        return dto;
    }
}