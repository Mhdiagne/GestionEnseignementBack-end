package com.uasz.daos_microservice_emplois.restController;

import com.uasz.daos_microservice_emplois.entity.Batiment;
import com.uasz.daos_microservice_emplois.service.BatimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/batimentsrest")
public class BatimentRestController {


    @Autowired
    private BatimentService batimentService;

    @GetMapping
    public List<Batiment> getAllBatiment() {
        return batimentService.getAllBatiment();
    }

    @GetMapping("/{id}")
    public Batiment getOneBatiment(@PathVariable Long id) {
        return batimentService.getBatimentById(id);
    }

    @PostMapping("/create")
    public  Batiment createBatiment(@RequestBody Batiment B) {
        return batimentService.createBatiment(B);
    }

    @PutMapping("/edit/{id}")
    public Batiment editBatiment(@PathVariable Long id, @RequestBody Batiment B) {
        return batimentService.updateBatiment(id, B);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBatiment(@PathVariable Long id) {
        batimentService.deleteBatiment(id);
    }
}
