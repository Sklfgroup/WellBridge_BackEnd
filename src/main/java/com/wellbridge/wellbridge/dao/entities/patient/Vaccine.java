package com.wellbridge.wellbridge.dao.entities.patient;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Vaccine extends AntecedentMedical{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
