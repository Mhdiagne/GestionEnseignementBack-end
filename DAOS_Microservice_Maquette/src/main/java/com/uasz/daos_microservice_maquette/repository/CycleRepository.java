package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.Cycle;
import com.uasz.daos_microservice_maquette.entity.Niveau;

import java.util.List;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long> {
    @Query("SELECT niv FROM Niveau AS niv WHERE niv.cycle = ?1 ")
    List<Niveau> findByNiveau(Cycle cycle);
}
