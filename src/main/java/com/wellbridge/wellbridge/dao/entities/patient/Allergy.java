package com.wellbridge.wellbridge.dao.entities.patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "allergies")
public class Allergy extends AntecedentMedical{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
