package com.uasz.daos_microservice_emplois.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uasz.daos_microservice_emplois.entity.Seance;
import com.uasz.daos_microservice_emplois.entity.Batiment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Salle;
    private String libelle;
    private String code;
    private int capacite;
    private String description;
    private Date dateCreation;

    @JsonIgnore
    @OneToMany(mappedBy = "salle")
    private List<Seance> seances;

    @ManyToOne
    @JoinColumn(name="batiment")
    private Batiment batiment;
}
