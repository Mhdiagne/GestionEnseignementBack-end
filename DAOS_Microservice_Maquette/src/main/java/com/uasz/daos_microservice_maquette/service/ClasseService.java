package com.uasz.daos_microservice_maquette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uasz.daos_microservice_maquette.entity.Classe;
import com.uasz.daos_microservice_maquette.repository.ClasseRepository;

import java.util.List;

@Service
@Transactional
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    // Methode permettant de creer un UE
    public Classe ajouterClasse(Classe classe) {
        classeRepository.save(classe);
        return classe;
    }

    public List<Classe> literToutesClasses() {
        return classeRepository.findAll();
    }

    // public Iterable<UE> literToutUE() {
    // return ueRepository.findAll();
    // }
    //
    // // public Optional<UE> rechercherUE(Long id) {
    // // return ueRepository.findById(id);
    // // }

    public Classe rechercherClasse(Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    public Classe ModifierClasse(Classe classe) {
        Classe classeModifier = rechercherClasse(classe.getId());
        if (classeModifier != null) {
            classe.setLibelle(classe.getLibelle());

            return classeRepository.save(classeModifier);
        }
        return null;
    }

    public void supprimerClasse(Classe classe) {
        classeRepository.delete(classe);
    }
}
