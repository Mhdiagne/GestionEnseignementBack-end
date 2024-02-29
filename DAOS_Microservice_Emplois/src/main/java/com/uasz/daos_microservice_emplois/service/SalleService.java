package com.uasz.daos_microservice_emplois.service;


import com.uasz.daos_microservice_emplois.entity.Salle;
import com.uasz.daos_microservice_emplois.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    public List<Salle> getAllSalle(){
        return salleRepository.findAll();
    }

    public Salle getSalleById(Long id){
        return salleRepository.findById(id).orElse(null);
    }

    public Salle createSalle(Salle S){
        S.setDateCreation(new Date());
        return salleRepository.save(S);
    }

    public Salle updateSalle(Long id, Salle S) {
        Salle newS = salleRepository.findById(id).get();
        if (salleRepository.existsById(id)){
            newS.setLibelle(S.getLibelle());
            newS.setCode(S.getCode());
            newS.setCapacite(S.getCapacite());
            newS.setDescription(S.getDescription());
        }
        return salleRepository.save(newS);
    }

    public void deleteSalle(Long id){
        salleRepository.deleteById(id);
    }
}
