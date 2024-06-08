package com.example.curriculo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo_api.model.Educacao;

public interface EducacaoRepository extends JpaRepository<Educacao, Long> {
}
