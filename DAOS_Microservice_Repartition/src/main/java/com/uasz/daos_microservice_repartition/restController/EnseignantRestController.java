package com.uasz.daos_microservice_repartition.restController;


import com.uasz.daos_microservice_repartition.entity.Enseignant;
import com.uasz.daos_microservice_repartition.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/enseignantsrest")
public class EnseignantRestController {
    @Autowired
    private EnseignantService enseignantService;

    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignants();
    }

    @GetMapping("/{id}")
    public Enseignant getOneEnseignant(@PathVariable Long id) {
        return enseignantService.getEnseignatById(id);
    }

    @PutMapping("/edit/{id}")
    public Enseignant editEnseignant(@PathVariable Long id, @RequestBody Enseignant E) {
        return enseignantService.updateEnseignant(id,E);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEnseignat(@PathVariable Long id) {
        enseignantService.deleteEnseignant(id);
    }

}
