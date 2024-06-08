package com.example.curriculo_api.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus; // Add this import statement
import org.springframework.http.ResponseEntity; // Add this import statement

import com.example.curriculo_api.model.Educacao;
import com.example.curriculo_api.repository.EducacaoRepository;

@RunWith(MockitoJUnitRunner.class)
public class EducacaoControllerTest {

    @Mock
    private EducacaoRepository educacaoRepository;

    @InjectMocks
    private EducacaoController educacaoController;

    @Test
    public void testGetEducacaoById() {
        // Criar um objeto Educacao simulado
        Educacao educacao = new Educacao();
        educacao.setId(1L);
        educacao.setInstitution("Universidade X");
        educacao.setCourse("Ciência da Computação");

        // Simular o comportamento do repositório
        when(educacaoRepository.findById(1L)).thenReturn(java.util.Optional.of(educacao));

        // Chamar o método do controlador
        ResponseEntity<Educacao> response = educacaoController.getEducacaoById(1L);

        // Verificar se a resposta está correta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(educacao, response.getBody());
    }
}
