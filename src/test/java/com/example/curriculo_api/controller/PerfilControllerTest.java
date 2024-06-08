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

import com.example.curriculo_api.model.Perfil;
import com.example.curriculo_api.repository.PerfilRepository;

@RunWith(MockitoJUnitRunner.class)
public class PerfilControllerTest {

    @Mock
    private PerfilRepository perfilRepository;

    @InjectMocks
    private PerfilController perfilController;

    @Test
    public void testGetPerfilById() {
        // Criar um objeto Perfil simulado
        Perfil perfil = new Perfil();
        perfil.setId(1L);
        perfil.setName("João Silva");
        perfil.setEmail("joao.silva@gmail.com");
        perfil.setPhone("(11) 99999-9999");
        perfil.setSummary("Desenvolvedor Full Stack");


        // Simular o comportamento do repositório
        when(perfilRepository.findById(1L)).thenReturn(java.util.Optional.of(perfil));

        // Chamar o método do controlador
        ResponseEntity<Perfil> response = perfilController.getPerfilById(1L);

        // Verificar se a resposta está correta
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(perfil, response.getBody());
    }
}
