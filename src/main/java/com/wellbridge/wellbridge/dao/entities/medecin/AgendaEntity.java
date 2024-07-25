package com.wellbridge.wellbridge.dao.entities.medecin;

import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "agendas")
public class AgendaEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private boolean morning;
    private boolean afternoon;
    private boolean evening;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private AccountEntity doctor;

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointments = new ArrayList<>();
}