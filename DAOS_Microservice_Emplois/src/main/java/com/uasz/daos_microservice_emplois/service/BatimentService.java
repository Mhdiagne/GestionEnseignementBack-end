package com.uasz.daos_microservice_emplois.service;


import com.uasz.daos_microservice_emplois.entity.Batiment;
import com.uasz.daos_microservice_emplois.repository.BatimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BatimentService {
    @Autowired
    private BatimentRepository batimentRepository;

    public List<Batiment> getAllBatiment(){
        return batimentRepository.findAll();
    }

    public Batiment getBatimentById(Long id){
        return batimentRepository.findById(id).orElse(null);
    }

    public Batiment createBatiment(Batiment B){
        B.setDateCreation(new Date());
        return batimentRepository.save(B);
    }

    public Batiment updateBatiment(Long id, Batiment B) {
        Batiment newB = batimentRepository.findById(id).get();
        if (batimentRepository.existsById(id)){
            newB.setCode(B.getCode());
            newB.setLibelle(B.getLibelle());
            newB.setPosition(B.getPosition());
            newB.setDescription(B.getDescription());
        }
        return batimentRepository.save(newB);
    }

    public void deleteBatiment(Long id){
        Batiment batiment= batimentRepository.findById(id).get();
        batimentRepository.delete(batiment);
    }
}
