package com.wellbridge.wellbridge.services;




import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import com.wellbridge.wellbridge.rest.dto.requests.patient.AppointmentRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AppointmentResponseDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentResponseDTO saveAppointment(AppointmentRequestDTO appointmentRequestDTO);
    List<AppointmentResponseDTO> getAppointmentsByPatientId(Long patientId);
    AppointmentResponseDTO findById(Long id);
    AppointmentResponseDTO updateAppointmentStatus(Long appointmentId, String status);
}