package com.uasz.daos_microservice_maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.entity.Formation;
import com.uasz.daos_microservice_maquette.entity.Niveau;
import com.uasz.daos_microservice_maquette.repository.NiveauRepository;

import java.util.Date;
import java.util.List;

@Service
public class NiveauService {
    @Autowired
    private NiveauRepository niveauRepository;

    public Niveau ajouterNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    public void supprimerNiveau(Niveau niveau) {
        niveauRepository.delete(niveau);
    }

    public Niveau rechercherNiveau(Long id) {
        return niveauRepository.findById(id).orElse(null);
    }

    public Niveau modifierNiveau(Long id, Niveau niveau) {
        Niveau niveauModifier = rechercherNiveau(id);

        if (niveauModifier != null) {
            niveauModifier.setLibelle(niveau.getLibelle());
            niveauModifier.setDescription(niveau.getDescription());
            niveauModifier.setDateCreation(new Date());

            return niveauRepository.save(niveauModifier);
        }
        return null;
    }

    public List<Formation> afficherToutesFormation(Niveau niveau) {
        return niveauRepository.findByFormation(niveau);
    }

    public List<Niveau> listerToutNiveau() {
        return niveauRepository.findAll();
    }
}
