package com.wellbridge.wellbridge.dao.entities.patient;

import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "access_requests")
public class AccessRequest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medecin_id", nullable = false)
    private AccountEntity medecin;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private AccountEntity patient;

    @Enumerated(EnumType.STRING)
    private AccessStatus status;
}