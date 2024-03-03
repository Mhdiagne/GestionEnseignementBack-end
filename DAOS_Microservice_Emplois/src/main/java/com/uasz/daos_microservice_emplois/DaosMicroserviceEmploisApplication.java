package com.uasz.daos_microservice_emplois;

import com.uasz.daos_microservice_emplois.ms_repartition.service.RepartitionProxy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
public class DaosMicroserviceEmploisApplication implements CommandLineRunner {

//    public DaosMicroserviceEmploisApplication(RepartitionProxy repartitionProxy) {
//        this.repartitionProxy = repartitionProxy;
//    }
    public static void main(String[] args) {
        SpringApplication.run(DaosMicroserviceEmploisApplication.class, args);
    }

    //private final RepartitionProxy repartitionProxy;

    @Override
    public void run(String... args) throws  Exception {
        //System.out.println(repartitionProxy.getAllRepartition());
    }

}
