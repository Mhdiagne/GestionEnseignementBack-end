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
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle, code, description;
    private int credit, coefficient;
    private Date dateCreation;

    @OneToMany(mappedBy = "ue")
    private Collection<EC> ecs;
    @OneToMany(mappedBy = "ue")
    private Collection<Module> module;
}
