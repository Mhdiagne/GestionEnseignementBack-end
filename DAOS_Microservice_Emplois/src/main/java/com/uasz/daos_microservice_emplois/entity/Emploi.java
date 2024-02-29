package com.uasz.daos_microservice_emplois.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Emploi;
    private String duree;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateDebut;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateFin;
    private Date dateCreation;

    @JsonIgnore
    @OneToMany(mappedBy = "emploi", cascade = CascadeType.ALL)
    private List<Seance> seances;

}
