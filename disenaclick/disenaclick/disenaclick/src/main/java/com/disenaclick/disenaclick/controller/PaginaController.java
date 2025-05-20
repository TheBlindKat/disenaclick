package com.disenaclick.disenaclick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.disenaclick.disenaclick.model.Pagina;
import com.disenaclick.disenaclick.services.PaginaService;
import com.disenaclick.disenaclick.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/paginas")
public class PaginaController {
    @Autowired
    private PaginaService paginaService;

    @GetMapping
    public ResponseEntity<List<Pagina>> listar() {
        List<Pagina> pagina = paginaService.findAll();
        if (pagina.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagina> buscar(@PathVariable Long id) {
        try {
            Pagina pagina = paginaService.findById(id);
            return ResponseEntity.ok(pagina);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Pagina> guardar(@RequestBody Pagina pagina) {
        Pagina paginaNuevo = paginaService.save(pagina);
        return ResponseEntity.status(HttpStatus.CREATED).body(paginaNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagina> actualizar(@PathVariable Long id, @RequestBody Pagina pagina) {
        try {
            paginaService.save(pagina);
            return ResponseEntity.ok(pagina);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Pagina> patchPagina(@PathVariable Long id, @RequestBody Pagina partialPagina) {
        try {
            Pagina updatedPagina = paginaService.patchPagina(id, partialPagina);
            return ResponseEntity.ok(updatedPagina);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            paginaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
