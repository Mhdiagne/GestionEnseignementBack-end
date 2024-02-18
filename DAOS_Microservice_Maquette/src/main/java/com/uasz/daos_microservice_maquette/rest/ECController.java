package com.uasz.daos_microservice_maquette.rest;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.daos_microservice_maquette.entity.EC;
import com.uasz.daos_microservice_maquette.service.ECService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/mqt/ec")
public class ECController {
    @Autowired
    private ECService ecService;

    @GetMapping("/all")
    public List<EC> listerEC(){
        return ecService.listerToutECs();
    }

    @GetMapping("/{id}")
    public EC trouverEC(@PathVariable Long id){
        return ecService.afficherEC(id);
    }
   
    @PostMapping("/add")
    public EC ajouterEC(@RequestBody EC ec){
        return ecService.ajouterEC(ec);
    }

    @PutMapping("/{id}")
    public EC modifierEC(@PathVariable Long id, @RequestBody EC ec){
        return ecService.modifierEC(id, ec);
    }

    @DeleteMapping("/{id}")
    public void supprimerEC(@PathVariable Long id){
        EC ec = ecService.afficherEC(id);
        ecService.supprimerEC(ec);
    }
   
}
