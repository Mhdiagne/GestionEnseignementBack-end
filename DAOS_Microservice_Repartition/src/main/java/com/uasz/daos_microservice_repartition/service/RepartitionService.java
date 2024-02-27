package com.uasz.daos_microservice_repartition.service;


import com.uasz.daos_microservice_repartition.entity.Enseignant;
import com.uasz.daos_microservice_repartition.entity.Repartition;
import com.uasz.daos_microservice_repartition.repository.RepartitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RepartitionService {
    @Autowired
    private RepartitionRepository repartitionRepository;

//    @Autowired
//    private SeanceRepository seanceRepository;

    public List<Repartition> getAllRepartition(){
        return repartitionRepository.findAll();
    }

    public Repartition getRepartitionById(Long id){
        return repartitionRepository.findById(id).orElse(null);
    }

    public Repartition createRepartition(Repartition R){
        R.setDateCreation(new Date());
        return repartitionRepository.save(R);
    }

    public Repartition updateRepartition(Long id, Repartition R) {
        Repartition newR = repartitionRepository.findById(id).get();
        if (repartitionRepository.existsById(id)){
            newR.setDescription(R.getDescription());
        }
        return repartitionRepository.save(newR);
    }

    public void deleteRepartition(Long id){
        repartitionRepository.deleteById(id);
    }

    public List<Repartition> getAllRepartitionOfPER(Enseignant e){
        return repartitionRepository.findByEnseignant(e);
    }

//    public List<Seance> getAllSeanceOfRepartition(Repartition r) { return seanceRepository.findByRepartition(r); }

}
