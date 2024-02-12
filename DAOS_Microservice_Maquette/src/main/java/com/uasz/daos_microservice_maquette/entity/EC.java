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
public class EC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle, code, description;
    private short cm, td, tp, tpe, coefficient;
    private Date dateCreation = new Date();

    @ManyToOne
    private UE ue;
    @OneToMany(mappedBy = "ec")
    private Collection<Module> module;
}
