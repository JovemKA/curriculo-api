package com.example.curriculo_api.repository;

import com.example.curriculo_api.model.Habilidade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class HabilidadeRepositoryTest {

    @Autowired
    private HabilidadeRepository habilidadeRepository;

    @Test
    void shouldSaveHabilidade() {
        Habilidade habilidade = new Habilidade();
        habilidade.setName("Java");

        Habilidade savedHabilidade = habilidadeRepository.save(habilidade);

        assertThat(savedHabilidade).isNotNull();
        assertThat(savedHabilidade.getId()).isNotNull();
        assertThat(savedHabilidade.getName()).isEqualTo("Java");
    }
}
