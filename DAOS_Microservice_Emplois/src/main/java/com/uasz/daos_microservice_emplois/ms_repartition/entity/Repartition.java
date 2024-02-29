package com.uasz.daos_microservice_emplois.ms_repartition.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repartition {
    private Long id_Repartition;
    private String description;
    private Date dateCreation;
}