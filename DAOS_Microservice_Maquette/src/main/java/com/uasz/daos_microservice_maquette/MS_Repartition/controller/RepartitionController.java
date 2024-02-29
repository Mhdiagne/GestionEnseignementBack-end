package com.uasz.daos_microservice_maquette.MS_Repartition.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.uasz.daos_microservice_maquette.MS_Repartition.Interface.RepartitionProxy;
import com.uasz.daos_microservice_maquette.MS_Repartition.modele.Repartition;;


@RestController
public class RepartitionController {
    
    private final RepartitionProxy repartitionProxy = null;

    @GetMapping(path = "/maquette/repartition")
    public List<Repartition> listerRepartition(){
        return repartitionProxy.listerRepartion();
    }


}
