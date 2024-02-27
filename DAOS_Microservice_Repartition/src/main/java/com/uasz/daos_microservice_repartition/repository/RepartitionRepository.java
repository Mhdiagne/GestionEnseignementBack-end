package com.uasz.daos_microservice_repartition.repository;


import com.uasz.daos_microservice_repartition.entity.Enseignant;
import com.uasz.daos_microservice_repartition.entity.Repartition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepartitionRepository extends JpaRepository<Repartition, Long> {
    List<Repartition> findByEnseignant(Enseignant e);
}
