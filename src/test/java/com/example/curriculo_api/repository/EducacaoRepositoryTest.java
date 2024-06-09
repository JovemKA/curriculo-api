package com.example.curriculo_api.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.curriculo_api.model.Educacao;

@DataJpaTest
public class EducacaoRepositoryTest {

    @Autowired
    private EducacaoRepository educacaoRepository;

    @Test
    void shouldSaveEducacao() {
        Educacao educacao = new Educacao();
        educacao.setInstitution("Universidade X");
        educacao.setCourse("Ciência da Computação");

        Educacao savedEducacao = educacaoRepository.save(educacao);

        assertThat(savedEducacao).isNotNull();
        assertThat(savedEducacao.getId()).isNotNull();
        assertThat(savedEducacao.getInstitution()).isEqualTo("Universidade X");
    }
}
