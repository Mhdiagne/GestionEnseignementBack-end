package com.uasz.daos_microservice_emplois.repository;

import com.uasz.daos_microservice_emplois.entity.Seance;
import com.uasz.daos_microservice_emplois.entity.Repartition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {

}
