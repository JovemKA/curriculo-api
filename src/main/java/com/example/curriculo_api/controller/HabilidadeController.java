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

import com.example.curriculo_api.model.Habilidade;
import com.example.curriculo_api.repository.HabilidadeRepository;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadeController {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    @GetMapping
    public List<Habilidade> getAllHabilidades() {
        return habilidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habilidade> getHabilidadeById(@PathVariable Long id) {
        Optional<Habilidade> habilidade = habilidadeRepository.findById(id);
        return habilidade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Habilidade createHabilidade(@RequestBody Habilidade habilidade) {
        return habilidadeRepository.save(habilidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habilidade> updateHabilidade(@PathVariable Long id, @RequestBody Habilidade habilidadeDetails) {
        Optional<Habilidade> habilidade = habilidadeRepository.findById(id);
        if (habilidade.isPresent()) {
            Habilidade habilidadeAtualizada = habilidade.get();
            habilidadeAtualizada.setName(habilidadeDetails.getName());
            habilidadeAtualizada.setLevel(habilidadeDetails.getLevel());
            return ResponseEntity.ok(habilidadeRepository.save(habilidadeAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabilidade(@PathVariable Long id) {
        habilidadeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
