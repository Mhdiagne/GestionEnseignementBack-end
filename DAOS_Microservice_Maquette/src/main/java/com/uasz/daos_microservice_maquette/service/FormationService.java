package com.uasz.daos_microservice_maquette.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.entity.Formation;
import com.uasz.daos_microservice_maquette.repository.FormationRepository;

@Service
public class FormationService {
    @Autowired
    private FormationRepository formationRepository;

    public Formation ajouterFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    public Formation rechercherFormation(Long id) {
        return formationRepository.findById(id).orElse(null);
    }

    public Formation modifierFormation(Formation formation) {
        Formation formationModifier = rechercherFormation(formation.getId());

        if (formationModifier != null) {
            formationModifier.setLibelle(formation.getLibelle());
            formationModifier.setDescription(formation.getDescription());
            formationModifier.setDateCreation(new Date());

            return formationRepository.save(formationModifier);
        }
        return null;
    }

    public void supprimerFormation(Formation formation) {
        formationRepository.delete(formation);
    }
}
