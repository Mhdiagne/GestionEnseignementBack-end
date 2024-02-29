package com.uasz.daos_microservice_maquette.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.daos_microservice_maquette.entity.EC;
import com.uasz.daos_microservice_maquette.entity.UE;
import com.uasz.daos_microservice_maquette.repository.UeRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UeService {
    @Autowired
    private UeRepository ueRepository;

    // Methode permettant de creer un UE
    public UE ajouterUE(UE ue) {
        ueRepository.save(ue);
        return ue;
    }

    public List<UE> afficherToutUE() {
        return ueRepository.findAll();
    }

    public UE rechercherUE(Long id) {
        return ueRepository.findById(id).orElse(null);
    }

    public UE modifierUE(Long id, UE ue) {
        UE ueModifier = rechercherUE(id);
        if (ueModifier != null) {
            ueModifier.setCode(ue.getCode());
            ueModifier.setCoefficient(ue.getCoefficient());
            ueModifier.setCredit(ue.getCredit());
            ueModifier.setLibelle(ue.getLibelle());
            ueModifier.setDescription(ue.getDescription());
            ueModifier.setDateCreation(new Date());
            return ueRepository.save(ueModifier);
        }
        return null;
    }

    public void supprimerUE(UE ue) {
        ueRepository.delete(ue);
    }

    public List<EC> afficherLesEC(UE ue) {
        return ueRepository.findByUE(ue);
    }

}
