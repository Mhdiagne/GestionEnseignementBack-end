package com.uasz.daos_microservice_maquette.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.daos_microservice_maquette.entity.Filiere;
import com.uasz.daos_microservice_maquette.service.FiliereService;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/filiere")
public class FiliereController {
    @Autowired
    private FiliereService filiereService;

        @GetMapping
    public List<Filiere> listerFiliere(){
        return filiereService.afficherToutesFiliere();
    }

    @GetMapping("/{id}")
    public Filiere trouverFiliere(@PathVariable Long id){
        return filiereService.rechercherFiliere(id);
    }
   
    @PostMapping
    public Filiere ajouterFiliere(@RequestBody Filiere filiere){
        return filiereService.ajouterFiliere(filiere);
    }

    @PutMapping("/{id}")
    public Filiere modifierFiliere(@PathVariable Long id, @RequestBody Filiere filiere){
        return filiereService.modifierFiliere(id, filiere);
    }

    @DeleteMapping("/{id}")
    public void supprimerFiliere(@PathVariable Long id){
        Filiere filiere = filiereService.rechercherFiliere(id);
        filiereService.supprimerFiliere(filiere);
    }
}
