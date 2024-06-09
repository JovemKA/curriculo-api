package com.example.curriculo_api.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.curriculo_api.model.Experiencia;

@DataJpaTest
public class ExperienciaRepositoryTest {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Test
    void shouldSaveExperiencia() {
        Experiencia experiencia = new Experiencia();
        experiencia.setCompany("Empresa Y");
        experiencia.setPosition("Desenvolvedor Java");

        Experiencia savedExperiencia = experienciaRepository.save(experiencia);

        assertThat(savedExperiencia).isNotNull();
        assertThat(savedExperiencia.getId()).isNotNull();
        assertThat(savedExperiencia.getCompany()).isEqualTo("Empresa Y");
    }
}
