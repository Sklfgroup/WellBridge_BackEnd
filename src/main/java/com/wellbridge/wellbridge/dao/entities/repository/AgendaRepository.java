package com.wellbridge.wellbridge.dao.entities.repository;

import com.wellbridge.wellbridge.dao.entities.medecin.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
    List<AgendaEntity> findByDoctorId(Long doctorId);
}