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
@Table(name = "follow_up_files")
public class FollowUpFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @OneToMany(mappedBy = "followUpFile", cascade = CascadeType.ALL)
    private Set<Treatment> treatments;

    @OneToMany(mappedBy = "followUpFile", cascade = CascadeType.ALL)
    private Set<Consultation> consultations;

    @OneToMany(mappedBy = "followUpFile", cascade = CascadeType.ALL)
    private Set<Examination> examinations;
}