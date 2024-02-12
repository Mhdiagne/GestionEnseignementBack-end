package com.uasz.daos_microservice_maquette.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle, description;
    private int numero, effectif;
    private Date dateCreation;
    
    @ManyToOne
    private Classe classe;
    @OneToMany(mappedBy = "groupe")
    private Collection<Enseignement> enseignement;
}
