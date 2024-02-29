package com.uasz.daos_microservice_maquette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uasz.daos_microservice_maquette.entity.EC;
import com.uasz.daos_microservice_maquette.entity.Module;


import java.util.List;

@Repository
public interface ECRepository extends JpaRepository<EC, Long> {

    @Query("SELECT m FROM Module AS m WHERE m.ec = ?1")
    List<Module> findByModule(EC ec);
}
