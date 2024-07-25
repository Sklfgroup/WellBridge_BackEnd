package com.wellbridge.wellbridge.rest.controllers;



import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentStatus;
import com.wellbridge.wellbridge.rest.api.AppointmentControllerApi;
import com.wellbridge.wellbridge.rest.dto.requests.patient.AppointmentRequestDTO;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AppointmentResponseDTO;
import com.wellbridge.wellbridge.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin
public class AppointmentController implements AppointmentControllerApi {
    @Autowired
    private AppointmentService appointmentService;

    @Override
    public List<AppointmentResponseDTO> getAppointmentsByPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @Override
    public AppointmentResponseDTO createAppointment(@RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        return appointmentService.saveAppointment(appointmentRequestDTO);
    }

    @Override
    public AppointmentResponseDTO cancelAppointment(@PathVariable Long appointmentId) {
        return appointmentService.updateAppointmentStatus(appointmentId, "ANNULER");
    }

    @Override
    public AppointmentResponseDTO confirmAppointment(@PathVariable Long appointmentId) {
        return appointmentService.updateAppointmentStatus(appointmentId, "VALIDE");
    }
}