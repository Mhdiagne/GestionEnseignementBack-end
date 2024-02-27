package com.uasz.daos_microservice_repartition.service;


import com.uasz.daos_microservice_repartition.entity.PER;
import com.uasz.daos_microservice_repartition.repository.PER_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PER_Service {
    @Autowired
    private PER_Repository perRepository;

    public List<PER> getAllPER(){
        return perRepository.findAll();
    }

    public PER getPERById(Long id){
        return perRepository.findById(id).orElse(null);
    }

    public PER createPER(PER P){
        P.setDateCreation(new Date());
        return perRepository.save(P);
    }

    public PER updatePER(Long id,PER P) {
        PER newP = perRepository.findById(id).get();
        if (perRepository.existsById(id)){
            newP.setNom(P.getNom());
            newP.setPrenom(P.getPrenom());
            newP.setGrade(P.getGrade());
            newP.setMatricule(P.getMatricule());
        }
        return perRepository.save(newP);
    }

    public void deletePER(Long id){
        perRepository.deleteById(id);
    }

}
