package com.wellbridge.wellbridge.dao.entities.account;

import com.wellbridge.wellbridge.dao.entities.BaseEntity;
import com.wellbridge.wellbridge.dao.entities.patient.MedicalInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class AccountEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active = true;

    @Column(name ="firstname")
    private String firstname;

    @Column(name ="lastname")
    private String lastname;

    @Column(name ="password")
    private String password;

    @Column(name ="username")
    private String username;  // Utilisé pour l'authentification

    @Column(name="code")
    private String code;

    @Column(name="number")
    private String number;

    @Column(name="dateOfBirth")
    private String dateOfBirth;

    @Column(name="BloodGroup")
    private String BloodGroup;



    @Column(name = "adresse")
    private String adresse; // Correction de l'orthographe de "adresse"

    @Column(name="registrationNumber")
    private String registrationNumber;

    @Column(name = "isNotLocked", nullable = false)
    private boolean isNotLocked = false;

    private boolean firstUsage = true;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private MedicalInfo medicalInfo;

    @ManyToMany
    @JoinTable(
            name = "medecin_patients",
            joinColumns = @JoinColumn(name = "medecin_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private Set<AccountEntity> patients;

    @ManyToMany(mappedBy = "patients")
    private Set<AccountEntity> medecins;

    @Transient
    private String token;

    @Transient
    private String FirebaseToken;
}
