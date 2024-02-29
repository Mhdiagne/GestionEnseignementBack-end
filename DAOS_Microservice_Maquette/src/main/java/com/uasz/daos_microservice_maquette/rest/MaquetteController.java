package com.uasz.daos_microservice_maquette.rest;

import lombok.AllArgsConstructor;

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

import com.uasz.daos_microservice_maquette.entity.Maquette;
import com.uasz.daos_microservice_maquette.service.MaquetteService;

@RestController
@Transactional
@AllArgsConstructor
@RequestMapping("/maquette")
public class MaquetteController {

    @Autowired
    private MaquetteService maquetteService;

    @GetMapping
    public List<Maquette> listerMaquette(){
        return maquetteService.listerToutMaquette();
    }

    @GetMapping("/{id}")
    public Maquette trouverMaquette(@PathVariable Long id){
        return maquetteService.rechercherMaquette(id);
    }
   
    @PostMapping
    public Maquette ajouterMaquette(@RequestBody Maquette maquette){
        return maquetteService.ajouterMaquette(maquette);
    }

    @PutMapping("/{id}")
    public Maquette modifierMaquette(@PathVariable Long id, @RequestBody Maquette maquette){
        return maquetteService.modifierMaquette(id, maquette);
    }

    @DeleteMapping("/{id}")
    public void supprimerMaquette(@PathVariable Long id){
        Maquette maquette = maquetteService.rechercherMaquette(id);
        maquetteService.supprimerMaquette(maquette);
    }

}
