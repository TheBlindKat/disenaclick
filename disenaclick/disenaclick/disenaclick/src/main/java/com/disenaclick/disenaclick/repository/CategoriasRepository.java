package com.disenaclick.disenaclick.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disenaclick.disenaclick.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    List<Categorias> findByNombreNegocio(String nombreNegocio);

    List<Categorias> findById(Integer id);

    

    

}
