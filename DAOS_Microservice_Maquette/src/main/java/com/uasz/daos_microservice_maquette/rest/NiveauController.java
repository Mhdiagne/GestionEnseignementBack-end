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

import com.uasz.daos_microservice_maquette.entity.Niveau;
import com.uasz.daos_microservice_maquette.service.NiveauService;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/mqt/niveau")
public class NiveauController {
    @Autowired
    private NiveauService niveauService;

    @GetMapping("/all")
    public List<Niveau> listerNiveau(){
        return niveauService.listerToutNiveau();
    }

    @GetMapping("/{id}")
    public Niveau trouverNiveau(@PathVariable Long id){
        return niveauService.rechercherNiveau(id);
    }
   
    @PostMapping("/add")
    public Niveau ajouterNiveau(@RequestBody Niveau niveau){
        return niveauService.ajouterNiveau(niveau);
    }

    @PutMapping("/{id}")
    public Niveau modifierNiveau(@PathVariable Long id, @RequestBody Niveau niveau){
        return niveauService.modifierNiveau(id, niveau);
    }

    @DeleteMapping("/{id}")
    public void supprimerNiveau(@PathVariable Long id){
        Niveau niveau = niveauService.rechercherNiveau(id);
        niveauService.supprimerNiveau(niveau);
    }

}
