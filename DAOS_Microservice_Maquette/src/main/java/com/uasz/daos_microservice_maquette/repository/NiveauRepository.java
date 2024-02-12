package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uasz.daos_microservice_maquette.entity.Formation;
import com.uasz.daos_microservice_maquette.entity.Niveau;

import java.util.List;

//@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    @Query("SELECT for FROM Formation AS for WHERE for.niveau = ?1 ")
    List<Formation> findByFormation(Niveau niveau);
}
