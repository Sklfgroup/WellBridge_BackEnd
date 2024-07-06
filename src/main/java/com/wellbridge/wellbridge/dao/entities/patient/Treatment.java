package com.wellbridge.wellbridge.dao.entities.patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "treatments")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reason;
    private String posology;
    private String specialInstructions;
    private String specialConsiderations;

    @ManyToOne
    @JoinColumn(name = "follow_up_file_id")
    private FollowUpFile followUpFile;
}