package com.uasz.daos_microservice_repartition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("VAC")
public class Vacataire extends Enseignant {
    private String Specialite;
}
