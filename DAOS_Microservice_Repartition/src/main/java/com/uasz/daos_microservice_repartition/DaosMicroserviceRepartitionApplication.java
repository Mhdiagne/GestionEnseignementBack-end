package com.uasz.daos_microservice_repartition;

import com.uasz.daos_microservice_repartition.entity.PER;
import com.uasz.daos_microservice_repartition.entity.Repartition;
import com.uasz.daos_microservice_repartition.entity.Vacataire;
import com.uasz.daos_microservice_repartition.repository.PER_Repository;
import com.uasz.daos_microservice_repartition.repository.RepartitionRepository;
import com.uasz.daos_microservice_repartition.repository.VacataireRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@EnableDiscoveryClient
@SpringBootApplication
public class DaosMicroserviceRepartitionApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DaosMicroserviceRepartitionApplication.class);

    @Autowired
    private RepartitionRepository repartitionRepository;

    @Autowired
    private PER_Repository perRepository;

    @Autowired
    private VacataireRepository vacataireRepository;

    public static void main(String[] args) {
        SpringApplication.run(DaosMicroserviceRepartitionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Repartition> repartitions =new ArrayList<>();
        Vacataire vacataire1 = new Vacataire("Specialite1");
        vacataire1.setNom("Diop"); vacataire1.setPrenom("Ibrahima"); vacataire1.setGrade("titulaire"); vacataire1.setId_Enseignant(null); vacataire1.setDateCreation(new Date()); vacataire1.setRepartitions(repartitions);
        Vacataire vacataire2 = new Vacataire("Specialite2");
        vacataire2.setNom("Malack"); vacataire2.setPrenom("Mamadou"); vacataire2.setGrade("titulaire"); vacataire2.setId_Enseignant(null); vacataire2.setDateCreation(new Date()); vacataire2.setRepartitions(repartitions);
        vacataireRepository.saveAll(Arrays.asList(vacataire1,vacataire2));

        PER per1 = new PER("MAT001");
        per1.setPrenom("Djibi"); per1.setNom("FALL"); per1.setGrade("titulaire"); per1.setId_Enseignant(null); per1.setDateCreation(new Date());
        PER per2 = new PER("MAT002");
        per2.setPrenom("Doudou"); per2.setNom("NDIAYE"); per2.setGrade("titulaire"); per2.setId_Enseignant(null); per2.setDateCreation(new Date());
        PER per3 = new PER("MAT003");
        per3.setPrenom("Aissatou"); per3.setNom("SARR"); per3.setGrade("second"); per3.setId_Enseignant(null); per3.setDateCreation(new Date());
        PER per4 = new PER("MAT004");
        per4.setPrenom("Papa"); per4.setNom("GOUDIABY"); per4.setGrade("titulaire"); per4.setId_Enseignant(null); per4.setDateCreation(new Date());
        PER per5 = new PER("MAT005");
        per5.setPrenom("Yande"); per5.setNom("FALL"); per5.setGrade("second"); per5.setId_Enseignant(null); per5.setDateCreation(new Date());
        perRepository.saveAll(Arrays.asList(per2,per5,per3,per1,per4));


        Repartition repartition1 = new Repartition(null, "Repartition 1", new Date(), per2);
        repartition1.setEnseignant(per1);
        Repartition repartition2 = new Repartition(null, "Repartition 2", new Date(), null);
        repartition2.setEnseignant(vacataire2);
        Repartition repartition3 = new Repartition(null, "Repartition 3", new Date(), null);
        repartition3.setEnseignant(per4);
        Repartition repartition4 = new Repartition(null, "Repartition 4", new Date(), null);
        repartition4.setEnseignant(vacataire1);
        Repartition repartition5 = new Repartition(null, "Repartition 5", new Date(), null);
        repartition5.setEnseignant(per1);
        repartitionRepository.saveAll(Arrays.asList(repartition1,repartition2,repartition5,repartition3,repartition4));



        for (PER per : perRepository.findAll()){
            logger.info(per.getPrenom()+" "+per.getNom()+" "+per.getMatricule());
        }
        logger.info("Toutes les instanciations ont été créeé avec succes par Pegasus77 :)");

    }

}
