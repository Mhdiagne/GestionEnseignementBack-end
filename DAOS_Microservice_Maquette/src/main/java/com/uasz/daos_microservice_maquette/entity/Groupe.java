package com.uasz.daos_microservice_maquette.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    private int numero;
    private int effectif;
    private Date dateCreation = new Date();
    
    @ManyToOne
    private Classe classe;

    @JsonIgnore
    @OneToMany(mappedBy = "groupe")
    private Collection<Enseignement> enseignement;
}
