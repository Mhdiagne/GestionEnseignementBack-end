package com.uasz.daos_microservice_emplois.ms_repartition.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("VAC")
public class Vacataire extends Enseignant {
    private String Specialite;
}
