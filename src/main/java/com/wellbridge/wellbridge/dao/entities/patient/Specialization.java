package com.wellbridge.wellbridge.dao.entities.patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "specializations")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;

    @ManyToOne
    @JoinColumn(name = "medical_info_id")
    private MedicalInfo medicalInfo;

    @OneToMany(mappedBy = "specialization", cascade = CascadeType.ALL)
    private Set<FollowUpFile> followUpFiles;
}