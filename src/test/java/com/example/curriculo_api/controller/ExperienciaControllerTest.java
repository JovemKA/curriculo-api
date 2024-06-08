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

import com.example.curriculo_api.model.Experiencia;
import com.example.curriculo_api.repository.ExperienciaRepository;

@RunWith(MockitoJUnitRunner.class)
public class ExperienciaControllerTest {

    @Mock
    private ExperienciaRepository experienciaRepository;

    @InjectMocks
    private ExperienciaController experienciaController;

    @Test
    public void testGetExperienciaById() {
        // Criar um objeto Experiencia simulado
        Experiencia experiencia = new Experiencia();
        experiencia.setId(1L);
        experiencia.setCompany("Empresa Y");
        experiencia.setPosition("Desenvolvedor");

        // Simular o comportamento do repositório
        when(experienciaRepository.findById(1L)).thenReturn(java.util.Optional.of(experiencia));

        // Chamar o método do controlador
        ResponseEntity<Experiencia> response = experienciaController.getExperienciaById(1L);

        // Verificar se a resposta está correta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(experiencia, response.getBody());
    }
}
