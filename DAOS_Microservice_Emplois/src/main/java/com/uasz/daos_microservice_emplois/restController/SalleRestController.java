package com.uasz.daos_microservice_emplois.restController;

import com.uasz.daos_microservice_emplois.entity.Salle;
import com.uasz.daos_microservice_emplois.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/sallesrest")
public class SalleRestController {
    
    @Autowired
    private SalleService salleService;

    @GetMapping
    public List<Salle> getAllSalle() {
        return salleService.getAllSalle();
    }

    @GetMapping("/{id}")
    public Salle getOneSalle(@PathVariable Long id) {
        return salleService.getSalleById(id);
    }

    @PostMapping("/create")
    public  Salle createSalle(@RequestBody Salle S) {
        return salleService.createSalle(S);
    }

    @PutMapping("/edit/{id}")
    public Salle editSalle(@PathVariable Long id, @RequestBody Salle S) {
        return salleService.updateSalle(id, S);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
    }
}
