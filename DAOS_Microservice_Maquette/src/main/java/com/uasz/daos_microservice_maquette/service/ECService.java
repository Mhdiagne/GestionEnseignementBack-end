package com.uasz.daos_microservice_maquette.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.daos_microservice_maquette.entity.EC;
import com.uasz.daos_microservice_maquette.entity.Module;

import com.uasz.daos_microservice_maquette.repository.ECRepository;

import java.util.List;

@Service
@Transactional
public class ECService {
    @Autowired
    private ECRepository ecRepository;

    // Ajouter un nouveau EC
    public EC ajouterEC(EC ec) {
        return ecRepository.save(ec);
    }

    // Affichage des EC
    public List<EC> listerToutECs() {
        return ecRepository.findAll();
    }

    // Rechercher un EC
    public EC afficherEC(Long id) {
        return ecRepository.findById(id).orElse(null);
    }

    // Modifer un Ec
    public EC modifierEC(Long id, EC ec) {
        EC ecModifier = afficherEC(id);

        if (ecModifier != null) {
            ecModifier.setCode(ec.getCode());
            ecModifier.setLibelle(ec.getLibelle());
            ecModifier.setCm(ec.getCm());
            ecModifier.setTd(ec.getTd());
            ecModifier.setTd(ec.getTp());
            ecModifier.setTpe(ec.getTpe());
            ecModifier.setCoefficient(ec.getCoefficient());
            ecModifier.setDescription(ec.getDescription());
            ecModifier.setUe(ec.getUe());

            return ecRepository.save(ecModifier);
        }
        return null;
    }

    // Suppression d'un EC
    public void supprimerEC(EC ec) {
        ecRepository.delete(ec);
    }

    public List<Module> afficherLesModules(EC ec) {
        return ecRepository.findByModule(ec);
    }

}