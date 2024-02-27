package com.uasz.daos_microservice_emplois.repository;

import com.uasz.daos_microservice_emplois.entity.Deroulement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeroulementRepository extends JpaRepository<Deroulement, Long> {
}
