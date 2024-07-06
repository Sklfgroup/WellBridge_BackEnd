package com.wellbridge.wellbridge.dao.entities.patient;

import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "medical_info")
public class MedicalInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @OneToMany(mappedBy = "medicalInfo", cascade = CascadeType.ALL)
    private Set<Specialization> specializations;

    @OneToMany(mappedBy = "medicalInfo", cascade = CascadeType.ALL)
    private Set<AntecedentMedical> antecedents;
}
