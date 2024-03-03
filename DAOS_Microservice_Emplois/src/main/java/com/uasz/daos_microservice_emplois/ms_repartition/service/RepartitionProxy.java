package com.uasz.daos_microservice_emplois.ms_repartition.service;

import com.uasz.daos_microservice_emplois.entity.Repartition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="repartition-service", url = "localhost:8082")
public interface RepartitionProxy {

    @GetMapping(path = "/repartitionsrest")
    List<Repartition> getAllRepartition();

    @GetMapping(path = "/repartitionsrest/{id}")
    List<Repartition> getOneRepartition(@PathVariable Long id);
}
