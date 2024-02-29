package com.uasz.daos_microservice_repartition.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 3)
public abstract class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_Enseignant;
    private String nom;
    private String prenom;
    private String grade;
    private Date dateCreation;

    @JsonIgnore
    @OneToMany(mappedBy = "enseignant",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Repartition> repartitions = new ArrayList<>();
}
