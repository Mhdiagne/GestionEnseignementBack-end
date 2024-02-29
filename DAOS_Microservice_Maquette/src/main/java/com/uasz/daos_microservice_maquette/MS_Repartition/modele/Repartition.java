package com.uasz.daos_microservice_maquette.MS_Repartition.modele;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
// import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class Repartition {

    private Long id_Repartition;
    private String description;
    private Date dateCreation;

}