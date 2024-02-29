package com.uasz.daos_microservice_maquette.rest;

import java.util.List;

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

import com.uasz.daos_microservice_maquette.entity.Formation;
import com.uasz.daos_microservice_maquette.service.FormationService;

@Transactional
@RestController
@RequestMapping("/formation")
public class FormationController {
    @Autowired
    private FormationService formationService;

    @GetMapping
    public List<Formation> listerFormation(){
        return formationService.listerToutFormation();
    }

    @GetMapping("/{id}")
    public Formation trouverFormation(@PathVariable Long id){
        return formationService.rechercherFormation(id);
    }
   
    @PostMapping
    public Formation ajouterFormation(@RequestBody Formation formation){
        return formationService.ajouterFormation(formation);
    }

    @PutMapping("/{id}")
    public Formation modifierFormation(@PathVariable Long id, @RequestBody Formation formation){
        return formationService.modifierFormation(id, formation);
    }

    @DeleteMapping("/{id}")
    public void supprimerFormation(@PathVariable Long id){
        Formation formation = formationService.rechercherFormation(id);
        formationService.supprimerFormation(formation);
    }
}
