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

import com.example.curriculo_api.model.Experiencia;
import com.example.curriculo_api.repository.ExperienciaRepository;

@SpringBootTest
public class ExperienciaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ExperienciaRepository experienciaRepository;

    @InjectMocks
    private ExperienciaController experienciaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(experienciaController).build();
    }

    @Test
    void shouldCreateExperiencia() throws Exception {
        Experiencia experiencia = new Experiencia();
        experiencia.setId(1L);
        experiencia.setCompany("Empresa Y");
        experiencia.setPosition("Desenvolvedor Java");

        when(experienciaRepository.save(any(Experiencia.class))).thenReturn(experiencia);

        mockMvc.perform(post("/experiencia")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"company\":\"Empresa Y\", \"position\":\"Desenvolvedor\"}"))
                .andExpect(status().isOk());
    }
}
