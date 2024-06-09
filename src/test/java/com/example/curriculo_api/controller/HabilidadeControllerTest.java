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

import com.example.curriculo_api.model.Habilidade;
import com.example.curriculo_api.repository.HabilidadeRepository;

@SpringBootTest
public class HabilidadeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HabilidadeRepository habilidadeRepository;

    @InjectMocks
    private HabilidadeController habilidadeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(habilidadeController).build();
    }

    @Test
    void shouldCreateHabilidade() throws Exception {
        Habilidade habilidade = new Habilidade();
        habilidade.setId(1L);
        habilidade.setName("Java");
        habilidade.setLevel("Avançado");

        when(habilidadeRepository.save(any(Habilidade.class))).thenReturn(habilidade);

        mockMvc.perform(post("/habilidade")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Java\", \"level\":\"Avançado\"}"))
                .andExpect(status().isOk());
    }
}
