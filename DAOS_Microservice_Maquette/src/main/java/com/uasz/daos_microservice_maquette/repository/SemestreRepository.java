package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.Semestre;
import com.uasz.daos_microservice_maquette.entity.Module;


import java.util.List;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    @Query("SELECT mod FROM Module AS mod WHERE mod.semestre = ?1")
    List<Module> findByModule(Semestre semestre);
}
