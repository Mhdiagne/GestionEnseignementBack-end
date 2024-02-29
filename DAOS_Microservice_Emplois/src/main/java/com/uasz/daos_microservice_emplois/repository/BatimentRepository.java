package com.uasz.daos_microservice_emplois.repository;

import com.uasz.daos_microservice_emplois.entity.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatimentRepository extends JpaRepository<Batiment, Long> {
}
