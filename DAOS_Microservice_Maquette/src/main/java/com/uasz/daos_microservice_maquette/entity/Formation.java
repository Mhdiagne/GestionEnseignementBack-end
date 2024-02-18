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
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    private Date dateCreation = new Date();

    @OneToOne(mappedBy = "formation")
    private Maquette maquette;
    @ManyToOne
    private Niveau niveau;
    @OneToMany(mappedBy = "formation")
    private Collection<Classe> classe;
    @ManyToOne
    private Filiere filiere;
}
