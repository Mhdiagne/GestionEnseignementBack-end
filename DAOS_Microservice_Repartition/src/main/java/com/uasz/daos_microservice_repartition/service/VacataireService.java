package com.uasz.daos_microservice_repartition.service;


import com.uasz.daos_microservice_repartition.entity.Vacataire;
import com.uasz.daos_microservice_repartition.repository.VacataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VacataireService {

    @Autowired
    private VacataireRepository vacataireRepository;

    public List<Vacataire> getAllVacataire(){
        return vacataireRepository.findAll();
    }

    public Vacataire getVacataireById(Long id){
        return vacataireRepository.findById(id).orElse(null);
    }

    public Vacataire createVacataire(Vacataire V){
        V.setDateCreation(new Date());
        return vacataireRepository.save(V);
    }

    public Vacataire updateVacataire(Long id,Vacataire V) {
        Vacataire newP = vacataireRepository.findById(id).get();
        if (vacataireRepository.existsById(id)){
            newP.setNom(V.getNom());
            newP.setPrenom(V.getPrenom());
            newP.setGrade(V.getGrade());
            newP.setSpecialite(V.getSpecialite());
        }
        return vacataireRepository.save(newP);
    }

    public void deleteVacataire(Long id){
        vacataireRepository.deleteById(id);
    }
}
