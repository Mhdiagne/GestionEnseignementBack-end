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
public class Maquette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle, code;
    private Date dateCreation = new Date();
    @OneToOne
    private Formation formation;
    @OneToMany(mappedBy = "maquette")
    private Collection<Module> module;
}
