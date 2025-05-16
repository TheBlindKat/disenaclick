package com.disenaclick.disenaclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disenaclick.disenaclick.model.Componentes;

@Repository
public interface ComponentesRepository extends JpaRepository<Componentes, Long> {

    List<Componentes> findByTituloComponente(String tituloComponente);

    List<Componentes> findById(Integer id);

}
