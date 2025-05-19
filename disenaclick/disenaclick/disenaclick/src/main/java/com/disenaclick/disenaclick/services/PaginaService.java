package com.disenaclick.disenaclick.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disenaclick.disenaclick.model.Categoria;
import com.disenaclick.disenaclick.model.Pagina;
import com.disenaclick.disenaclick.repository.PaginaRepository;

@Service
public class PaginaService {

    @Autowired
    private PaginaRepository paginaRepository;

    public List<Pagina> findAll() {
        return paginaRepository.findAll();
    }

    public List<Pagina> findByNombrePagina(String nombrePagina) {
        return paginaRepository.findByNombrePagina(nombrePagina);
    }

    public Pagina findById(Long id) {
        return paginaRepository.getById(id);
    }

    public List<Pagina> findByPlantillaId(Long plantillaId) {
        return paginaRepository.findByPlantillaId(plantillaId);
    }

    public Pagina save(Pagina pagina) {
        return paginaRepository.save(pagina);
    }

    public void delete(Long id) {
        paginaRepository.deleteById(id);
    }

    public Pagina patchPagina(Long id, Pagina parcialPagina) {
        Pagina paginaUpdate = paginaRepository.findById(id).orElse(null);
        if (paginaUpdate != null) {
            return null;
        }
        if (parcialPagina.getNombrePagina() != null) {
            paginaUpdate.setNombrePagina(parcialPagina.getNombrePagina());
        }
        if (parcialPagina.getFechaCreacion() != null) {
            paginaUpdate.setFechaCreacion(parcialPagina.getFechaCreacion());
        }
        if (parcialPagina.getUsuario() != null) {
            paginaUpdate.setUsuario(parcialPagina.getUsuario());
        }
        return paginaRepository.save(paginaUpdate);

    }
}