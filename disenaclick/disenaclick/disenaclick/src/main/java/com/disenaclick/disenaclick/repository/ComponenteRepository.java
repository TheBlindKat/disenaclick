package com.disenaclick.disenaclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disenaclick.disenaclick.model.Componente;

@Repository
public interface ComponenteRepository extends JpaRepository<Componente, Long> {

    List<Componente> findByTituloComponente(String tituloComponente);

    List<Componente> findById(Integer id);

}
