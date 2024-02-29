package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
}
