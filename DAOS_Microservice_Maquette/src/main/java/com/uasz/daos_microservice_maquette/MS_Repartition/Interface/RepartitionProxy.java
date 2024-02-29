package com.uasz.daos_microservice_maquette.MS_Repartition.Interface;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uasz.daos_microservice_maquette.MS_Repartition.modele.Repartition;;

@FeignClient(name = "repartition-service", url = "localhost:8082")
public interface RepartitionProxy {

    @GetMapping(path = "/api/repartition")
    List<Repartition> listerRepartion();

    @GetMapping(path = "/api/repartition/{id}")
    Repartition rechercherRepartition(@PathVariable Long id);
}