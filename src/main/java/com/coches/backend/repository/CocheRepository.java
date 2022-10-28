package com.coches.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.coches.backend.model.Coche;

public interface CocheRepository extends JpaRepository<Coche,Long>, JpaSpecificationExecutor<Coche>{
    
}
