package com.disenaclick.disenaclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disenaclick.disenaclick.model.CategoriaComponente;

@Repository
public interface CategoriaComponenteRepository extends JpaRepository<CategoriaComponente, Long> {

    

}
