package com.uasz.daos_microservice_maquette.rest;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.daos_microservice_maquette.entity.Classe;
import com.uasz.daos_microservice_maquette.service.ClasseService;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/classe")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public List<Classe> listerClasse(){
        return classeService.literToutesClasses();
    }

    @GetMapping("/{id}")
    public Classe trouverClasse(@PathVariable Long id){
        return classeService.rechercherClasse(id);
    }
   
    @PostMapping
    public Classe ajouterClasse(@RequestBody Classe classe){
        return classeService.ajouterClasse(classe);
    }

    @PutMapping("/{id}")
    public Classe modifierClasse(@PathVariable Long id, @RequestBody Classe classe){
        return classeService.modifierClasse(id, classe);
    }

    @DeleteMapping("/{id}")
    public void supprimerClasse(@PathVariable Long id){
        Classe classe = classeService.rechercherClasse(id);
        classeService.supprimerClasse(classe);
    }

}
