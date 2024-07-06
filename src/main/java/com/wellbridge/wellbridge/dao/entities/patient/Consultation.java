package com.wellbridge.wellbridge.dao.entities.patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;
    private String clinicalExamination;
    private String preliminaryDiagnosis;
    private String medicalPrescription;

    @ManyToOne
    @JoinColumn(name = "follow_up_file_id")
    private FollowUpFile followUpFile;
}