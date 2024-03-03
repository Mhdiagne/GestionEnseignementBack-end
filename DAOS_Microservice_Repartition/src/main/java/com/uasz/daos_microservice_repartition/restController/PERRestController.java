package com.uasz.daos_microservice_repartition.restController;

import com.uasz.daos_microservice_repartition.entity.PER;
import com.uasz.daos_microservice_repartition.service.PER_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/persrest")
public class PERRestController {

    @Autowired private PER_Service perService;
    

    private Long idPer;

    @GetMapping
    public List<PER> getAllPER() {
        return perService.getAllPER();
    }

    @GetMapping("/{id}")
    public PER getOnePER(@PathVariable Long id) {
        return perService.getPERById(id);
    }

    @PostMapping("/create")
    public  PER createPER(@RequestBody PER P) {
        return perService.createPER(P);
    }

    @PutMapping("/edit/{id}")
    public PER editPER(@PathVariable Long id, @RequestBody PER P) {
        return perService.updatePER(id, P);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePER(@PathVariable Long id) {
        perService.deletePER(id);
    }
}
