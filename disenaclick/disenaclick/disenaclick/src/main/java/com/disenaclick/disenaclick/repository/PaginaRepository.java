package com.disenaclick.disenaclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disenaclick.disenaclick.model.Pagina;
import com.disenaclick.disenaclick.model.Usuario;

@Repository
public interface PaginaRepository extends JpaRepository<Pagina, Long> {

    List<Pagina> findByNombrePagina(String nombrePagina);

    List<Pagina> findById(Integer id);

    List<Pagina> findByUsuario(Usuario usuario);

    List<Pagina> findByUsuarioId(Long usuarioId);

    List<Pagina> findByPlantillaId(Long plantillaId);

}
