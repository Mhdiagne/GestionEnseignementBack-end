package com.uasz.daos_microservice_maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.entity.Cycle;
import com.uasz.daos_microservice_maquette.entity.Niveau;
import com.uasz.daos_microservice_maquette.repository.CycleRepository;

import java.util.Date;
import java.util.List;

@Service
public class CycleService {
    @Autowired
    private CycleRepository cycleRepository;

    // Methode permettant d'ajouter un cycle
    public Cycle ajouterCycle(Cycle cycle) {
        return cycleRepository.save(cycle);
    }

    // Rechercher un cycle par son identifiant
    public Cycle rechercherCycle(Long id) {
        return cycleRepository.findById(id).orElse(null);
    }

    // Supprimer un cycle
    public void supprimerCycle(Cycle cycle) {
        cycleRepository.delete(cycle);
    }

    // Modification d'un cycle
    public Cycle modifierCycle(Cycle cycle) {
        Cycle cycleModifier = rechercherCycle(cycle.getId());

        if (cycleModifier != null) {
            cycleModifier.setLibelle(cycle.getLibelle());
            cycleModifier.setDateCreation(new Date());
            cycleModifier.setDescription(cycle.getDescription());

            return cycleRepository.save(cycleModifier);
        }

        return null;
    }

    public List<Cycle> afficherToutCycle() {
        return cycleRepository.findAll();
    }

    public List<Niveau> afficherLesNiveaux(Cycle cycle) {
        return cycleRepository.findByNiveau(cycle);
    }

}
