package com.uasz.daos_microservice_maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.repository.ModuleRepository;
import com.uasz.daos_microservice_maquette.entity.Module;

import java.util.Date;
import java.util.List;

@Service
public class ModuleService {
  @Autowired
  private ModuleRepository moduleRepository;

  public Module ajouterModule(Module module) {
    moduleRepository.save(module);
    return module;
  }

  public Module rechercherModule(Long id) {
    return moduleRepository.findById(id).orElse(null);
  }

  // Suppression d'un module
  public void supprimerModule(Module module) {
    moduleRepository.delete(module);
  }

  // Modification du module
  public Module modifierModule(Long id, Module module) {
    Module moduleModifier = rechercherModule(id);

    if (moduleModifier != null) {
      moduleModifier.setCours(module.getCours());
      moduleModifier.setLibelle(module.getLibelle());
      moduleModifier.setDateCreation(new Date());
      moduleModifier.setObjectifs(module.getObjectifs());
      moduleModifier.setDuree(module.getDuree());
      moduleModifier.setDescription(module.getDescription());
      return moduleRepository.save(moduleModifier);
    }

    return null;
  }

public List<Module> listerToutModule() {
    return moduleRepository.findAll();
}
}
