package com.uasz.daos_microservice_maquette.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.entity.Maquette;
import com.uasz.daos_microservice_maquette.repository.MaquetteRepository;


@Service
public class MaquetteService {

  @Autowired
  private MaquetteRepository maquetteRepository;

  // Ajouter une maquette
  public Maquette ajouterMaquette(Maquette maquette) {
    return maquetteRepository.save(maquette);
  }

  public Maquette rechercherMaquette(Long id) {
    return maquetteRepository.findById(id).get();
  }

  public List<Maquette> listerToutMaquette() {
    return maquetteRepository.findAll();    
  }

  public Maquette modifierMaquette(Long id, Maquette maquette) {
    Maquette maquetteModifier = rechercherMaquette(id);

        if (maquetteModifier != null) {
            maquetteModifier.setLibelle(maquette.getLibelle());
            maquetteModifier.setDateCreation(new Date());
            maquetteModifier.setDescription(maquette.getDescription());
            maquetteModifier.setCode(maquette.getCode());

            return maquetteRepository.save(maquetteModifier);
        }

        return null;

  }

  public void supprimerMaquette(Maquette maquette) {
    maquetteRepository.deleteById(null);
  }
}
