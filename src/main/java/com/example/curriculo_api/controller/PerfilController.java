package com.example.curriculo_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.curriculo_api.model.Perfil;
import com.example.curriculo_api.repository.PerfilRepository;

@RestController
@RequestMapping("/api/perfis")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Perfil> getAllPerfis() {
        return perfilRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Perfil createPerfil(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable Long id, @RequestBody Perfil perfilDetails) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        if (perfil.isPresent()) {
            Perfil perfilAtualizado = perfil.get();
            perfilAtualizado.setName(perfilDetails.getName());
            perfilAtualizado.setEmail(perfilDetails.getEmail());
            perfilAtualizado.setPhone(perfilDetails.getPhone());
            perfilAtualizado.setSummary(perfilDetails.getSummary());
            return ResponseEntity.ok(perfilRepository.save(perfilAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable Long id) {
        perfilRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
