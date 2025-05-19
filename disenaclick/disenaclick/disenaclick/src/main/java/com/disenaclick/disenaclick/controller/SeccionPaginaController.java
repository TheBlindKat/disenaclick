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

import com.disenaclick.disenaclick.model.SeccionPagina;
import com.disenaclick.disenaclick.services.SeccionPaginaService;

@RestController
@RequestMapping("api/v1/secciones")
public class SeccionPaginaController {
    @Autowired
    private SeccionPaginaService seccionPaginaService;

    @GetMapping
    public ResponseEntity<List<SeccionPagina>> listar() {
        List<SeccionPagina> secciones = seccionPaginaService.findAll();
        if (secciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(secciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeccionPagina> getSeccionById(@PathVariable Long id) {
        SeccionPagina seccion = seccionPaginaService.findById(id);
        if (seccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seccion);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<SeccionPagina>> getSeccionesByTitulo(@PathVariable String titulo) {
        List<SeccionPagina> secciones = seccionPaginaService.findByTitulo(titulo);
        if (secciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(secciones);
    }

    @PostMapping
    public ResponseEntity<SeccionPagina> guardar(@RequestBody SeccionPagina seccionPagina) {
        SeccionPagina nueva = seccionPaginaService.save(seccionPagina);
        return ResponseEntity.status(201).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeccion(@PathVariable Long id) {
        try {
            seccionPaginaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeccionPagina> updateSeccion(@PathVariable Long id,
            @RequestBody SeccionPagina seccionPagina) {
        SeccionPagina actualizada = seccionPaginaService.updateSeccionPagina(id, seccionPagina);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SeccionPagina> patchSeccion(@PathVariable Long id,
            @RequestBody SeccionPagina parcialSeccion) {
        SeccionPagina actualizada = seccionPaginaService.patchSeccionPagina(id, parcialSeccion);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

}
