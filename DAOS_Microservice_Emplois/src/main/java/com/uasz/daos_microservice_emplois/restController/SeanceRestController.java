package com.uasz.daos_microservice_emplois.restController;



import com.uasz.daos_microservice_emplois.entity.Seance;
import com.uasz.daos_microservice_emplois.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/seancesrest")
public class SeanceRestController {
    
    @Autowired
    private SeanceService seanceService;

    @GetMapping
    public List<Seance> getAllSeance() {
        return seanceService.getAllSeance();
    }

    @GetMapping("/{id}")
    public Seance getOneSeance(@PathVariable Long id) {
        return seanceService.getSeanceById(id);
    }

    @PostMapping("/create")
    public  Seance createSeance(@RequestBody Seance S) {
        return seanceService.createSeance(S);
    }

    @PutMapping("/edit/{id}")
    public Seance editSeance(@PathVariable Long id, @RequestBody Seance S) {
        return seanceService.updateSeance(id, S);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
    }
}
