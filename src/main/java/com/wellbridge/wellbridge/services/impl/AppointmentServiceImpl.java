package com.wellbridge.wellbridge.services.impl;


import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import com.wellbridge.wellbridge.dao.entities.repository.AppointmentRepository;
import com.wellbridge.wellbridge.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentEntity saveAppointment(AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<AppointmentEntity> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public AppointmentEntity findById(Long id) {
        Optional<AppointmentEntity> appointmentOpt = appointmentRepository.findById(id);
        return appointmentOpt.orElse(null);
    }
}