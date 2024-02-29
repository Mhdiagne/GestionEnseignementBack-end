package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
}
