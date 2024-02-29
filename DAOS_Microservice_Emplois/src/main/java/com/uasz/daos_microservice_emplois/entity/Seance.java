package com.uasz.daos_microservice_emplois.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Seance;
    private String jour;
    private String duree;
    private String heureDebut;
    private String heureFin;
    private int numero;
    private Date dateCreation;


    @ManyToOne
    @JoinColumn(name = "emploi")
    private Emploi emploi;

    @JsonIgnore
    @OneToOne(mappedBy = "seance",cascade = CascadeType.ALL)
    private Deroulement deroulement;

    @ManyToOne
    @JoinColumn(name = "salle")
    private Salle salle;
}
