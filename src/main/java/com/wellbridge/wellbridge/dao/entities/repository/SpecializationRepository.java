package com.wellbridge.wellbridge.dao.entities.repository;

import com.wellbridge.wellbridge.dao.entities.patient.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}