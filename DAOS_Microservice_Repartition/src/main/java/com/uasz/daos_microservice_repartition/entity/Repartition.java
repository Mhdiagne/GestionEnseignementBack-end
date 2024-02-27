package com.uasz.daos_microservice_repartition.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Repartition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Repartition;
    private String description;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name="id_Enseignant",insertable = false,updatable = false)
    private Enseignant enseignant;

}
