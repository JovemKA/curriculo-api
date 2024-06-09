package com.example.curriculo_api.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.curriculo_api.model.Perfil;

@DataJpaTest
public class PerfilRepositoryTest {

    @Autowired
    private PerfilRepository perfilRepository;

    @Test
    void shouldSavePerfil() {
        Perfil perfil = new Perfil();
        perfil.setName("João Silva");
        perfil.setEmail("joao.silva@gmail.com");
        perfil.setPhone("(81) 9 9999-9999");
        perfil.setSummary("Desenvolvedor Java");

        Perfil savedPerfil = perfilRepository.save(perfil);

        assertThat(savedPerfil).isNotNull();
        assertThat(savedPerfil.getId()).isNotNull();
        assertThat(savedPerfil.getName()).isEqualTo("João Silva");
    }
}
