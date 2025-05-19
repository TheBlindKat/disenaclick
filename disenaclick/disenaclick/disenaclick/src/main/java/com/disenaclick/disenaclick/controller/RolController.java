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

import com.disenaclick.disenaclick.model.Rol;
import com.disenaclick.disenaclick.services.RolService;

@RestController
@RequestMapping("api/v1/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> listar() {
        List<Rol> roles = rolService.findAll();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Long id) {
        Rol rol = rolService.findById(id);
        if (rol != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<Rol> guardar(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.save(rol);
        return ResponseEntity.status(201).body(nuevoRol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        try {
            rolService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Long id, @RequestBody Rol rol) {
        Rol actualizado = rolService.save(rol);
        return ResponseEntity.ok(actualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Rol> patchRol(@PathVariable Long id, @RequestBody Rol parcialRol) {
        Rol actualizado = rolService.patchRol(id, parcialRol);
        if (actualizado != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }
}