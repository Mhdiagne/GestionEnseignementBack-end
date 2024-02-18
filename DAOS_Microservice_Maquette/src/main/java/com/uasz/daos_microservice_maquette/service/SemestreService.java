package com.uasz.daos_microservice_maquette.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.entity.Semestre;
import com.uasz.daos_microservice_maquette.repository.SemestreRepository;

@Service
public class SemestreService {

  @Autowired
  private SemestreRepository semestreRepository;

  // Ajouter un semestre
  public Semestre ajouterSemestre(Semestre semestre) {
    return semestreRepository.save(semestre);
  }

  // Rechercher un semestre avec son identifiant
  public Semestre rechercherSemestre(Long id) {
    return semestreRepository.findById(id).get();
  }

  // Supression d'un semestre
  public void supprimerSemestre(Semestre semestre) {
    semestreRepository.delete(semestre);
  }

  // Modification d'un semestre
  public Semestre modifierSemestre(Long id, Semestre semestre) {
    Semestre semestreModifier = rechercherSemestre(id);

    if (semestreModifier != null) {
      semestreModifier.setLibelle(semestre.getLibelle());
      semestreModifier.setDescription(semestre.getDescription());
      semestreModifier.setDateCreation(new Date());

      return semestreRepository.save(semestreModifier);
    }
    return null;
  }

public List<Semestre> listerToutSemestre() {
    return semestreRepository.findAll();
}
}
