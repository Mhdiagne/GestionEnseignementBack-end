package com.uasz.daos_microservice_maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.entity.Filiere;
import com.uasz.daos_microservice_maquette.entity.Formation;
import com.uasz.daos_microservice_maquette.repository.FiliereRepository;

import java.util.Date;
import java.util.List;

@Service
public class FiliereService {
    @Autowired
    private FiliereRepository filiereRepository;

    public Filiere ajouterFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    public Filiere rechercherFiliere(Long id) {
        return filiereRepository.findById(id).orElse(null);
    }

    public void supprimerFiliere(Filiere filiere) {
        filiereRepository.delete(filiere);
    }

    public Filiere modifierFiliere(Long id, Filiere filiere) {
        Filiere filiereModifier = rechercherFiliere(id);

        if (filiereModifier != null) {
            filiereModifier.setLibelle(filiere.getLibelle());
            filiereModifier.setDescription(filiere.getDescription());
            filiereModifier.setDateCreation(new Date());

            return filiereRepository.save(filiereModifier);
        }
        return null;
    }

    public List<Filiere> afficherToutesFiliere() {
        return filiereRepository.findAll();
    }

    public List<Formation> afficherToutesFormation(Filiere filiere) {
        return filiereRepository.findByFormation(filiere);
    }
}
