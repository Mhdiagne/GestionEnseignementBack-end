package com.uasz.daos_microservice_emplois.service;


import com.uasz.daos_microservice_emplois.entity.Deroulement;
import com.uasz.daos_microservice_emplois.repository.DeroulementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeroulementService {

    @Autowired
    private DeroulementRepository deroulementRepository;

    public List<Deroulement> getAllDeroulement(){
        return deroulementRepository.findAll();
    }

    public Deroulement getDeroulementById(Long id){
        return deroulementRepository.findById(id).orElse(null);
    }

    public Deroulement createDeroulement(Deroulement D){
        D.setDateCreation(new Date());
        return deroulementRepository.save(D);
    }

    public Deroulement updateDeroulement(Long id, Deroulement D) {
        Deroulement newD = deroulementRepository.findById(id).get();
        if (deroulementRepository.existsById(id)){
            newD.setObjectifs(D.getObjectifs());
            newD.setDescription(D.getDescription());
        }
        return deroulementRepository.save(newD);
    }

    public void deleteDeroulement(Long id){
        deroulementRepository.deleteById(id);
    }
}
