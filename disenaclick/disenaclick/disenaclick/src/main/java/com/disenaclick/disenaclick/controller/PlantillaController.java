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

import com.disenaclick.disenaclick.model.Plantilla;
import com.disenaclick.disenaclick.services.PlantillaService;
import com.disenaclick.disenaclick.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/plantillas")
public class PlantillaController {
    @Autowired
    private PlantillaService plantillaService;

    @GetMapping
    public ResponseEntity<List<Plantilla>> listar() {
        List<Plantilla> plantillas = plantillaService.findAll();
        if (plantillas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(plantillas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plantilla> buscar(@PathVariable Long id) {
        try {
            Plantilla plantilla = plantillaService.findById(id);
            return ResponseEntity.ok(plantilla);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Plantilla> guardar(@RequestBody Plantilla plantilla) {
        Plantilla plantillaNueva = plantillaService.save(plantilla);
        return ResponseEntity.status(HttpStatus.CREATED).body(plantillaNueva);/* Import HttpStatus */
    }

    @PutMapping
    public ResponseEntity<Plantilla> actualizar(@PathVariable Long id, @RequestBody Plantilla plantilla) {
        try {
            plantillaService.save(plantilla);
            return ResponseEntity.ok(plantilla);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Plantilla> patchPlantilla(@PathVariable Long id, @RequestBody Plantilla partialPlantilla) {
        try {
            Plantilla updatePlantilla = plantillaService.patchPlantilla(id, partialPlantilla);
            return ResponseEntity.ok(updatePlantilla);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            plantillaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
