package com.uasz.daos_microservice_emplois.service;

import com.uasz.daos_microservice_emplois.entity.Seance;
import com.uasz.daos_microservice_emplois.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeanceService {
    
    @Autowired
    private SeanceRepository seanceRepository;

    public List<Seance> getAllSeance(){
        return seanceRepository.findAll();
    }

    public Seance getSeanceById(Long id){
        return seanceRepository.findById(id).orElse(null);
    }

    public Seance createSeance(Seance S){
        S.setDateCreation(new Date());
        return seanceRepository.save(S);
    }

    public Seance updateSeance(Long id, Seance S) {
        Seance newS = seanceRepository.findById(id).get();
        if (seanceRepository.existsById(id)){
            newS.setJour(S.getJour());
            newS.setDuree(S.getDuree());
            newS.setHeureDebut(S.getHeureDebut());
            newS.setHeureFin(S.getHeureFin());
            newS.setNumero(S.getNumero());
        }
        return seanceRepository.save(newS);
    }

    public void deleteSeance(Long id){
        seanceRepository.deleteById(id);
    }
}
