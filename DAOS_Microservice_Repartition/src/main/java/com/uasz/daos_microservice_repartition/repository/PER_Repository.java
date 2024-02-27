package com.uasz.daos_microservice_repartition.repository;


import com.uasz.daos_microservice_repartition.entity.PER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PER_Repository extends JpaRepository<PER, Long> {
}
