package com.example.curriculo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo_api.model.Habilidade;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
}
