package com.uasz.daos_microservice_emplois.repository;

import com.uasz.daos_microservice_emplois.entity.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploiRepository extends JpaRepository<Emploi, Long> {
}
