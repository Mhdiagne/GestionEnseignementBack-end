package com.uasz.daos_microservice_emplois.service;


import com.uasz.daos_microservice_emplois.entity.Emploi;
import com.uasz.daos_microservice_emplois.repository.EmploiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmploiService {

    @Autowired
    private EmploiRepository emploiRepository;

    public List<Emploi> getAllEmploi(){
        return emploiRepository.findAll();
    }

    public Emploi getEmploiById(Long id){
        return emploiRepository.findById(id).orElse(null);
    }

    public Emploi createEmploi(Emploi E){
        E.setDateCreation(new Date());
        return emploiRepository.save(E);
    }

    public Emploi updateEmploi(Long id, Emploi E) {
        Emploi newE = emploiRepository.findById(id).get();
        if (emploiRepository.existsById(id)){
            newE.setDuree(E.getDuree());
            newE.setDateDebut(E.getDateDebut());
            newE.setDateFin(E.getDateFin());
        }
        return emploiRepository.save(newE);
    }

    public void deleteEmploi(Long id){
        emploiRepository.deleteById(id);
    }
}
