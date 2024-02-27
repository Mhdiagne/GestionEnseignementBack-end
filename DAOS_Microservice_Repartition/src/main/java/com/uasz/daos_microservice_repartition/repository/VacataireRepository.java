package com.uasz.daos_microservice_repartition.repository;

import com.uasz.daos_microservice_repartition.entity.Vacataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacataireRepository extends JpaRepository<Vacataire, Long> {
}
