package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.Filiere;
import com.uasz.daos_microservice_maquette.entity.Formation;

import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    @Query("SELECT for FROM Formation AS for WHERE for.filiere = ?1 ")
    List<Formation> findByFormation(Filiere filiere);
}
