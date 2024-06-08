package com.example.curriculo_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.curriculo_api.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
