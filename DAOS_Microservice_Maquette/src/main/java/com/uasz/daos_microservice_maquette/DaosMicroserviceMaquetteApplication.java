package com.uasz.daos_microservice_maquette;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


import com.uasz.daos_microservice_maquette.MS_Repartition.Interface.RepartitionProxy;


@EnableDiscoveryClient
@SpringBootApplication
public class DaosMicroserviceMaquetteApplication implements CommandLineRunner{

    public DaosMicroserviceMaquetteApplication(RepartitionProxy repartitionProxy){
        this.repartitionProxy = repartitionProxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(DaosMicroserviceMaquetteApplication.class, args);
    }

    private final RepartitionProxy repartitionProxy;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(repartitionProxy.listerRepartion());
    }

}
