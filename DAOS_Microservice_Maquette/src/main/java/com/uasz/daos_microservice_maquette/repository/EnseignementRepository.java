package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.Enseignement;

@Repository
public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {
}
