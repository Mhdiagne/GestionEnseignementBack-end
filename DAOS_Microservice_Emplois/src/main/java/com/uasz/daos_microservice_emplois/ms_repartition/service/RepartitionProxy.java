package com.uasz.daos_microservice_emplois.ms_repartition.service;

import com.uasz.daos_microservice_emplois.entity.Repartition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="repartition-service", url = "localhost:8082")
public interface RepartitionProxy {

    @GetMapping(path = "/repartition/api/repartitions")
    List<Repartition> ListerRepartition();

    @GetMapping(path = "/repartition/api/repartitions/{id}")
    List<Repartition> ListerUneRepartition(@PathVariable Long id);
}
