package com.uasz.daos_microservice_emplois.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Deroulement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Deroulement;
    private String objectifs;
    private String description;
    private Date dateCreation;

    @OneToOne
    private Seance seance;
}
