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

import com.uasz.daos_microservice_maquette.entity.Cycle;
import com.uasz.daos_microservice_maquette.service.CycleService;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/cycle")
public class CycleController {
    @Autowired
    private CycleService cycleService;

    @GetMapping
    public List<Cycle> listerCycle(){
        return cycleService.afficherToutCycle();
    }

    @GetMapping("/{id}")
    public Cycle trouverCycle(@PathVariable Long id){
        return cycleService.rechercherCycle(id);
    }
   
    @PostMapping
    public Cycle ajouterCycle(@RequestBody Cycle cycle){
        return cycleService.ajouterCycle(cycle);
    }

    @PutMapping("/{id}")
    public Cycle modifierCycle(@PathVariable Long id, @RequestBody Cycle cycle){
        return cycleService.modifierCycle(id, cycle);
    }

    @DeleteMapping("/{id}")
    public void supprimerCycle(@PathVariable Long id){
        Cycle cycle = cycleService.rechercherCycle(id);
        cycleService.supprimerCycle(cycle);
    }
}
