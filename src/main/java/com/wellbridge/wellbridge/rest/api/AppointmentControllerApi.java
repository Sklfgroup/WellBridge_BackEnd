package com.wellbridge.wellbridge.rest.api;

import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public interface AppointmentControllerApi {
    @GetMapping("/patient/{patientId}")
    List<AppointmentEntity> getAppointmentsByPatient(@PathVariable Long patientId);

    @PostMapping
    AppointmentEntity createAppointment(@RequestBody AppointmentEntity appointment);

    @PutMapping("/{appointmentId}/cancel")
    AppointmentEntity cancelAppointment(@PathVariable Long appointmentId);

    @PutMapping("/{appointmentId}/confirm")
    AppointmentEntity confirmAppointment(@PathVariable Long appointmentId);
}