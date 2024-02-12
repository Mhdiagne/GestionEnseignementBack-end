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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle, cours, objectifs, description;
    private short duree;
    private Date dateCreation = new Date();

    @OneToMany(mappedBy = "module")
    private Collection<Enseignement> enseignement;
    @ManyToOne
    private Semestre semestre;
    @ManyToOne
    private Maquette maquette;
    @ManyToOne
    private UE ue;
    @ManyToOne
    private EC ec;
}
