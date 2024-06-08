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

import com.example.curriculo_api.model.Experiencia;
import com.example.curriculo_api.repository.ExperienciaRepository;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @GetMapping
    public List<Experiencia> getAllExperiencias() {
        return experienciaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> getExperienciaById(@PathVariable Long id) {
        Optional<Experiencia> experiencia = experienciaRepository.findById(id);
        return experiencia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Experiencia createExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experiencia> updateExperiencia(@PathVariable Long id, @RequestBody Experiencia experienciaDetails) {
        Optional<Experiencia> experiencia = experienciaRepository.findById(id);
        if (experiencia.isPresent()) {
            Experiencia experienciaAtualizada = experiencia.get();
            experienciaAtualizada.setPosition(experienciaDetails.getPosition());
            experienciaAtualizada.setCompany(experienciaDetails.getCompany());
            experienciaAtualizada.setDescription(experienciaDetails.getDescription());
            experienciaAtualizada.setStartDate(experienciaDetails.getStartDate());
            experienciaAtualizada.setEndDate(experienciaDetails.getEndDate());
            return ResponseEntity.ok(experienciaRepository.save(experienciaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperiencia(@PathVariable Long id) {
        experienciaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
