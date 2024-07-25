package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import com.wellbridge.wellbridge.rest.dto.requests.patient.AppointmentRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AppointmentResponseDTO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface AppointmentControllerApi {
    @GetMapping("/patient/{patientId}")
    List<AppointmentResponseDTO> getAppointmentsByPatient(@PathVariable Long patientId);

    @PostMapping
    AppointmentResponseDTO createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO);

    @PutMapping("/{appointmentId}/cancel")
    AppointmentResponseDTO cancelAppointment(@PathVariable Long appointmentId);

    @PutMapping("/{appointmentId}/confirm")
    AppointmentResponseDTO confirmAppointment(@PathVariable Long appointmentId);
}