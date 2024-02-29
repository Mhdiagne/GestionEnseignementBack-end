package com.uasz.daos_microservice_repartition.restController;


import com.uasz.daos_microservice_repartition.entity.Repartition;
import com.uasz.daos_microservice_repartition.service.PER_Service;
import com.uasz.daos_microservice_repartition.service.RepartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/repartitionsrest")
public class RepartitionRestController {

    @Autowired
    private RepartitionService repartitionService;

    @Autowired
    private PER_Service perService;

    @GetMapping
    public ResponseEntity<List<Repartition>> getAllRepartition() {
        if (!repartitionService.getAllRepartition().isEmpty())
            return new ResponseEntity<>(repartitionService.getAllRepartition(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public Repartition getOneRepartition(@PathVariable Long id) {
        return repartitionService.getRepartitionById(id);
    }

    @PostMapping("/create")
    public  Repartition createRepartition(@RequestBody Repartition R) {
        return repartitionService.createRepartition(R);
    }

    @PutMapping("/edit/{id}")
    public Repartition editRepartition(@PathVariable Long id, @RequestBody Repartition R) {
        return repartitionService.updateRepartition(id, R);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRepartition(@PathVariable Long id) {
        repartitionService.deleteRepartition(id);
    }
}
