package com.disenaclick.disenaclick.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.disenaclick.disenaclick.model.Pagina;
import com.disenaclick.disenaclick.repository.PaginaRepository;

@Service
public class PaginaService {


    @Autowired
    private PaginaRepository paginaRepository;
    public List <Pagina> findAll(){
        return paginaRepository.findAll();
    }

    public List<Pagina>findByNombrePagina(String nombrePagina){
        return paginaRepository.findByNombrePagina(nombrePagina);
    }

    public Pagina guardarPagina(Pagina pagina) {
        return paginaRepository.save(pagina);
    }

    public void eliminarPagina(Long id) {
        paginaRepository.deleteById(id);
    }

}