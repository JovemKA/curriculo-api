package com.example.curriculo_api.controller;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.curriculo_api.model.Habilidade;
import com.example.curriculo_api.repository.HabilidadeRepository;

@RunWith(MockitoJUnitRunner.class)
public class HabilidadeControllerTest {

    @Mock
    private HabilidadeRepository habilidadeRepository;

    @InjectMocks
    private HabilidadeController habilidadeController;

    @Test
    public void testGetHabilidadeById() {
        // Criar um objeto Habilidade simulado
        Habilidade habilidade = new Habilidade();
        habilidade.setId(1L);
        habilidade.setName("Java");
        habilidade.setLevel("Avançado");

        // Simular o comportamento do repositório
        when(habilidadeRepository.findById(1L)).thenReturn(java.util.Optional.of(habilidade));

        // Chamar o método do controlador
        ResponseEntity<Habilidade> response = habilidadeController.getHabilidadeById(1L);

        // Verificar se a resposta está correta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(habilidade, response.getBody());
    }
}
