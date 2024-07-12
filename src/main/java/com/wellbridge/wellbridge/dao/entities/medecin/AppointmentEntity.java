package com.wellbridge.wellbridge.dao.entities.medecin;


import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class AppointmentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime time;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status; // "En attente", "Valide", "Annuler"

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private AgendaEntity agenda;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private AccountEntity patient;
}