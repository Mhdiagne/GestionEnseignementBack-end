package com.uasz.daos_microservice_emplois.repository;


import com.uasz.daos_microservice_emplois.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Long> {
}
