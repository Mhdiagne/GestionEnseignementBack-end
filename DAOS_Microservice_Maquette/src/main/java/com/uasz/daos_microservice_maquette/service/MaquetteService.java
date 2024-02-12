package com.uasz.daos_microservice_maquette.service;

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
}
