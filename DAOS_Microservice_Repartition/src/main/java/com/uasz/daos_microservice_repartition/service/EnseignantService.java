package com.uasz.daos_microservice_repartition.service;

import com.uasz.daos_microservice_repartition.entity.Enseignant;
import com.uasz.daos_microservice_repartition.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepository enseignantRepository;

    public List<Enseignant> getAllEnseignants(){
        return enseignantRepository.findAll();
    }

    public Enseignant getEnseignatById(Long id){
        return enseignantRepository.findById(id).orElse(null);
    }

    public Enseignant CreateEnseignant(Enseignant E){
        return enseignantRepository.save(E);
    }

    public Enseignant updateEnseignant(Long id,Enseignant E) {
        Enseignant newE = enseignantRepository.findById(id).get();
        if (enseignantRepository.existsById(id)){
            newE.setId_Enseignant(E.getId_Enseignant());
            newE.setNom(E.getNom());
            newE.setPrenom(E.getPrenom());
            newE.setGrade(E.getGrade());
        }
        return newE;
    }

    public void deleteEnseignant(Long id){
        enseignantRepository.deleteById(id);
    }

}
