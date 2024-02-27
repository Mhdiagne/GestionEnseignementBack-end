package com.uasz.daos_microservice_emplois.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Batiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Batiment;
    private String libelle;
    private String code;
    private String position;
    private String description;
    private Date dateCreation;

    @JsonIgnore
    @OneToMany(mappedBy = "batiment", cascade = CascadeType.ALL)
    private List<Salle> salles;
}
