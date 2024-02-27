package com.uasz.daos_microservice_emplois.restController;


import com.uasz.daos_microservice_emplois.entity.Emploi;
import com.uasz.daos_microservice_emplois.service.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/emploisrest")
public class EmploiRestController {
    
    @Autowired
    private EmploiService emploiService;

    @GetMapping
    public List<Emploi> getAllEmploi() {
        return emploiService.getAllEmploi();
    }

    @GetMapping("/{id}")
    public Emploi getOneEmploi(@PathVariable Long id) {
        return emploiService.getEmploiById(id);
    }

    @PostMapping("/create")
    public  Emploi createEmploi(@RequestBody Emploi E) {
        return emploiService.createEmploi(E);
    }

    @PutMapping("/edit/{id}")
    public Emploi editEmploi(@PathVariable Long id, @RequestBody Emploi E) {
        return emploiService.updateEmploi(id, E);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmploi(@PathVariable Long id) {
        emploiService.deleteEmploi(id);
    }
}
