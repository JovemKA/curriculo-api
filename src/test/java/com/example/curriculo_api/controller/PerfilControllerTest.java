package com.example.curriculo_api.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.curriculo_api.model.Perfil;
import com.example.curriculo_api.repository.PerfilRepository;

@SpringBootTest
public class PerfilControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PerfilRepository perfilRepository;

    @InjectMocks
    private PerfilController perfilController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(perfilController).build();
    }

    @Test
    void shouldCreatePerfil() throws Exception {
        Perfil perfil = new Perfil();
        perfil.setId(1L);
        perfil.setName("João Silva");
        perfil.setEmail("joao.silva@gmail.com");
        perfil.setPhone("(81) 9 9999-9999");
        perfil.setSummary("Desenvolvedor Java");

        when(perfilRepository.save(any(Perfil.class))).thenReturn(perfil);

        mockMvc.perform(post("/perfil")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"João Silva\", \"email\":\"joao.silva@gmail.com\", \"phone\":\"(81) 9 9999-9999\", \"summary\":\"Desenvolvedor Java\"}"))
                .andExpect(status().isOk());
    }
}
