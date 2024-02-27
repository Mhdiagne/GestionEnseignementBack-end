package com.uasz.daos_microservice_repartition.restController;

import com.uasz.daos_microservice_repartition.entity.Vacataire;
import com.uasz.daos_microservice_repartition.service.VacataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vacatairesrest")
public class VacataireRestController {

    @Autowired
    private VacataireService vacataireService;

    @GetMapping
    public List<Vacataire> getAllVacataire() {
        return vacataireService.getAllVacataire();
    }

    @GetMapping("/{id}")
    public Vacataire getOneVacataire(@PathVariable Long id) {
        return vacataireService.getVacataireById(id);
    }

    @PostMapping("/create")
    public  Vacataire createVacataire(@RequestBody Vacataire V) {
        return vacataireService.createVacataire(V);
    }

    @PutMapping("/edit/{id}")
    public Vacataire editVacataire(@PathVariable Long id, @RequestBody Vacataire V) {
        return vacataireService.updateVacataire(id,V);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVacataire(@PathVariable Long id) {
        vacataireService.deleteVacataire(id);
    }
}
