package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.Module;


@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
