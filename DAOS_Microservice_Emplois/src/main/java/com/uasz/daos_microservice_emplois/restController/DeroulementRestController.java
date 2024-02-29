package com.uasz.daos_microservice_emplois.restController;



import com.uasz.daos_microservice_emplois.entity.Deroulement;
import com.uasz.daos_microservice_emplois.service.DeroulementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/deroulementsrest")
public class DeroulementRestController {

    @Autowired
    private DeroulementService deroulementService;

    @GetMapping
    public List<Deroulement> getAllDeroulement() {
        return deroulementService.getAllDeroulement();
    }

    @GetMapping("/{id}")
    public Deroulement getOneDeroulement(@PathVariable Long id) {
        return deroulementService.getDeroulementById(id);
    }

    @PostMapping("/create")
    public  Deroulement createDeroulement(@RequestBody Deroulement D) {
        return deroulementService.createDeroulement(D);
    }

    @PutMapping("/edit/{id}")
    public Deroulement editDeroulement(@PathVariable Long id, @RequestBody Deroulement D) {
        return deroulementService.updateDeroulement(id, D);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeroulement(@PathVariable Long id) {
        deroulementService.deleteDeroulement(id);
    }
}
