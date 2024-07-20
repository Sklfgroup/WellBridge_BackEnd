package com.wellbridge.wellbridge.rest.controllers;



import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentStatus;
import com.wellbridge.wellbridge.rest.api.AppointmentControllerApi;
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
    public List<AppointmentEntity> getAppointmentsByPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatientId(patientId);
    }

    @Override
    public AppointmentEntity createAppointment(@RequestBody AppointmentEntity appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @Override
    public AppointmentEntity cancelAppointment(@PathVariable Long appointmentId) {
        AppointmentEntity appointment = appointmentService.findById(appointmentId);
        if (appointment != null) {
            appointment.setStatus(AppointmentStatus.ANNULER);
            return appointmentService.saveAppointment(appointment);
        }
        // Gérer le cas où le rendez-vous n'existe pas
        return null;
    }

    @Override
    public AppointmentEntity confirmAppointment(@PathVariable Long appointmentId) {
        AppointmentEntity appointment = appointmentService.findById(appointmentId);
        if (appointment != null) {
            appointment.setStatus(AppointmentStatus.VALIDE);
            return appointmentService.saveAppointment(appointment);
        }
        // Gérer le cas où le rendez-vous n'existe pas
        return null;
    }

    // Autres méthodes possibles (mise à jour, suppression, etc.)
}