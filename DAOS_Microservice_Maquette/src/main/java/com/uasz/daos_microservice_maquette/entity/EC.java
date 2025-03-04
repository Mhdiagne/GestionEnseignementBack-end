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
public class EC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String code;
    private String description;
    private short cm;
    private short td;
    private short tp;
    private short tpe;
    private short coefficient;

    private Date dateCreation = new Date();

    @ManyToOne
    private UE ue;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ec")
    private Collection<Module> module;
}
