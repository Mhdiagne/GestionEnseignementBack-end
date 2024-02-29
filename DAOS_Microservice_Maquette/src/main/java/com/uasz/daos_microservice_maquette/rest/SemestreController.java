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

import com.uasz.daos_microservice_maquette.entity.Semestre;
import com.uasz.daos_microservice_maquette.service.SemestreService;


@RestController
@Transactional
@RequestMapping("/semestre")
public class SemestreController {
  @Autowired
  private SemestreService semestreService;

  @GetMapping
    public List<Semestre> listerSemestre(){
        return semestreService.listerToutSemestre();
    }

    @GetMapping("/{id}")
    public Semestre trouverSemestre(@PathVariable Long id){
        return semestreService.rechercherSemestre(id);
    }
   
    @PostMapping
    public Semestre ajouterSemestre(@RequestBody Semestre semestre){
        return semestreService.ajouterSemestre(semestre);
    }

    @PutMapping("/{id}")
    public Semestre modifierSemestre(@PathVariable Long id, @RequestBody Semestre semestre){
        return semestreService.modifierSemestre(id, semestre);
    }

    @DeleteMapping("/{id}")
    public void supprimerSemestre(@PathVariable Long id){
        Semestre semestre = semestreService.rechercherSemestre(id);
        semestreService.supprimerSemestre(semestre);
    }


}
