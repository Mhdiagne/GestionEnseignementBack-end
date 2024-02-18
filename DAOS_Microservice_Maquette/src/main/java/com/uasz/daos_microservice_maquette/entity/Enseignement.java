package com.uasz.daos_microservice_maquette.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enseignement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private String objectifs;
    private String description;
    private Date dateCreation = new Date();

    @ManyToOne
    private Groupe groupe;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Module module;
}
