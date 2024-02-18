package com.uasz.daos_microservice_maquette.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.daos_microservice_maquette.entity.UE;
import com.uasz.daos_microservice_maquette.service.UeService;

import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/mqt/ue")
public class UeController {
    @Autowired
    private UeService ueService;

    @GetMapping("/all")
    public List<UE> listerUE(){
        return ueService.afficherToutUE();
    }

    @GetMapping("/{id}")
    public UE trouverUE(@PathVariable Long id){
        return ueService.rechercherUE(id);
    }
   
    @PostMapping("/add")
    public UE ajouterUE(@RequestBody UE ue){
        return ueService.ajouterUE(ue);
    }

    @PutMapping("/{id}")
    public UE modifierUE(@PathVariable Long id, @RequestBody UE ue){
        return ueService.modifierUE(id, ue);
    }

    @DeleteMapping("/{id}")
    public void supprimerUE(@PathVariable Long id){
        UE ue = ueService.rechercherUE(id);
        ueService.supprimerUE(ue);
    }


}
