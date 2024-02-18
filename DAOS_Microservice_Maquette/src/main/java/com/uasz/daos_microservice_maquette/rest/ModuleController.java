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

import com.uasz.daos_microservice_maquette.entity.Module;
import com.uasz.daos_microservice_maquette.service.ModuleService;

@RestController
@Transactional
@RequestMapping("/mqt/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/all")
    public List<Module> listerModule(){
        return moduleService.listerToutModule();
    }

    @GetMapping("/{id}")
    public Module trouverModule(@PathVariable Long id){
        return moduleService.rechercherModule(id);
    }
   
    @PostMapping("/add")
    public Module ajouterModule(@RequestBody Module module){
        return moduleService.ajouterModule(module);
    }

    @PutMapping("/{id}")
    public Module modifierModule(@PathVariable Long id, @RequestBody Module module){
        return moduleService.modifierModule(id, module);
    }

    @DeleteMapping("/{id}")
    public void supprimerModule(@PathVariable Long id){
        Module module = moduleService.rechercherModule(id);
        moduleService.supprimerModule(module);
    }
}
