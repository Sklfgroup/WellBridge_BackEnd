package com.wellbridge.wellbridge.services;




import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;

import java.util.List;

public interface AppointmentService {
    AppointmentEntity saveAppointment(AppointmentEntity appointment);
    List<AppointmentEntity> getAppointmentsByPatientId(Long patientId);
    AppointmentEntity findById(Long id);
}