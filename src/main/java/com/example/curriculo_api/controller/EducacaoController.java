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

import com.example.curriculo_api.model.Educacao;
import com.example.curriculo_api.repository.EducacaoRepository;

@RestController
@RequestMapping("/api/educacoes")
public class EducacaoController {

    @Autowired
    private EducacaoRepository educacaoRepository;

    @GetMapping
    public List<Educacao> getAllEducacoes() {
        return educacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Educacao> getEducacaoById(@PathVariable Long id) {
        Optional<Educacao> educacao = educacaoRepository.findById(id);
        return educacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Educacao createEducacao(@RequestBody Educacao educacao) {
        return educacaoRepository.save(educacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Educacao> updateEducacao(@PathVariable Long id, @RequestBody Educacao educacaoDetails) {
        Optional<Educacao> educacao = educacaoRepository.findById(id);
        if (educacao.isPresent()) {
            Educacao educacaoAtualizada = educacao.get();
            educacaoAtualizada.setCourse(educacaoDetails.getCourse());
            educacaoAtualizada.setInstitution(educacaoDetails.getInstitution());
            educacaoAtualizada.setDescription(educacaoDetails.getDescription());
            educacaoAtualizada.setStartDate(educacaoDetails.getStartDate());
            educacaoAtualizada.setEndDate(educacaoDetails.getEndDate());
            return ResponseEntity.ok(educacaoRepository.save(educacaoAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducacao(@PathVariable Long id) {
        educacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
