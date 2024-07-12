package com.wellbridge.wellbridge.dao.entities.repository;


import com.wellbridge.wellbridge.dao.entities.medecin.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    List<AppointmentEntity> findByPatientId(Long patientId);
}