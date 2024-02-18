package com.uasz.daos_microservice_maquette.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String description;
    private int nombreGroupe;
    private int effectif;
    private Date dateCreation = new Date();


    @ManyToOne
    private Formation formation;
    @OneToMany(mappedBy = "classe")
    private Collection<Groupe> groupes;
    @OneToMany(mappedBy = "classe")
    private Collection<Enseignement> enseignements;
    @ManyToOne
    private Semestre semestre;

    // //Helper Methode 
    // public void addGroupe(Groupe groupe) {
    //   groupes.add(groupe);
    //   groupe.setClasse(this);
	  // }
 
    // public void removeComment(Groupe groupe) {
    //   groupes.remove(groupe);
    //   groupe.setClasse(null);
    // }

}
