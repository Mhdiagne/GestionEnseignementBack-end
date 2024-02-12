package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.EC;
import com.uasz.daos_microservice_maquette.entity.UE;

import java.util.List;

@Repository
public interface UeRepository extends JpaRepository<UE, Long> {
    @Query("SELECT e FROM EC AS e WHERE e.ue = ?1")
    List<EC> findByUE(UE ue);

}
