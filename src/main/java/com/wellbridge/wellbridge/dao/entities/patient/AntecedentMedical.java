package com.wellbridge.wellbridge.dao.entities.patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "antecedent_medicals")
public class AntecedentMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeSurgery;
    private String description;
    private String name;

    @ManyToOne
    @JoinColumn(name = "medical_info_id")
    private MedicalInfo medicalInfo;
}