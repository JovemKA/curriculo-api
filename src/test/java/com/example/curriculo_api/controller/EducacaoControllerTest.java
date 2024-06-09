package com.example.curriculo_api.controller;

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

import com.example.curriculo_api.model.Educacao;
import com.example.curriculo_api.repository.EducacaoRepository;

@SpringBootTest
public class EducacaoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EducacaoRepository educacaoRepository;

    @InjectMocks
    private EducacaoController educacaoController;

    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(educacaoController).build();
    }

    @Test
    void shouldCreateEducacao() throws Exception {
        Educacao educacao = new Educacao();
        educacao.setId(1L);
        educacao.setInstitution("Universidade X");
        educacao.setCourse("Ciência da Computação");
        
        
        when(educacaoRepository.save(any(Educacao.class))).thenReturn(educacao);
        
        mockMvc.perform(post("/educacao")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"institution\":\"Universidade X\", \"course\":\"Bacharelado\"}"))
                .andExpect(status().isOk());
    }
}
