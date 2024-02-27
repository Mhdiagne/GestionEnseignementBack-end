package com.uasz.daos_microservice_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DaosMicroserviceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaosMicroserviceConfigApplication.class, args);
    }

}
