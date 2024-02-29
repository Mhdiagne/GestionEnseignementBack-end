package com.uasz.daos_microservice_repartition.repository;


import com.uasz.daos_microservice_repartition.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
