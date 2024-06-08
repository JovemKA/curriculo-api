package com.example.curriculo_api.repository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.curriculo_api.model.Educacao;

@RunWith(MockitoJUnitRunner.class)
public class EducacaoRepositoryTest {

    @Mock
    private EducacaoRepository educacaoRepository;

    @InjectMocks
    private Educacao educacao;

    @Test
    public void testFindById() {
        // Criar um objeto Educacao simulado
        Educacao educacaoLocal = new Educacao();
        educacaoLocal.setId(1L);
        educacaoLocal.setCourse("Ciência da Computação");
        educacaoLocal.setInstitution("Universidade X");

        // Simular o comportamento do repositório
        when(educacaoRepository.findById(1L)).thenReturn(Optional.of(educacao));

        // Chamar o método do repositório
        Optional<Educacao> result = educacaoRepository.findById(1L);

        // Verificar se o resultado é o esperado
        assertEquals(educacao, result.get());
    }

    @Test
    public void testSaveEducacao() {
        // Criar um objeto Educacao simulado
        Educacao educacaoSimulado = new Educacao();
        educacaoSimulado.setId(1L);
        educacaoSimulado.setCourse("Ciência da Computação");
        educacaoSimulado.setInstitution("Universidade X");
    
        // Simular o comportamento do repositório
        when(educacaoRepository.save(any(Educacao.class))).thenReturn(educacaoSimulado);
    
        // Chamar o método de salvar do repositório
        Educacao savedEducacao = educacaoRepository.save(educacaoSimulado);
    
        // Verificar se o objeto retornado é o mesmo que foi salvo
        assertEquals(educacaoSimulado, savedEducacao);
    }

    @Test
    public void testUpdateEducacao() {
        // Criar um objeto Educacao simulado
        Educacao educacaoSimulado = new Educacao();
        educacaoSimulado.setId(1L);
        educacaoSimulado.setCourse("Ciência da Computação");
        educacaoSimulado.setInstitution("Universidade X");
    
        // Simular o comportamento do repositório
        when(educacaoRepository.save(any(Educacao.class))).thenReturn(educacaoSimulado);
    
        // Chamar o método de atualizar do repositório
        Educacao updatedEducacao = educacaoRepository.save(educacaoSimulado);
    
        // Verificar se o objeto retornado é o mesmo que foi atualizado
        assertEquals(educacaoSimulado, updatedEducacao);
    }

    @Test
    public void testDeleteEducacao() {
        // Chamar o método de deletar do repositório
        educacaoRepository.deleteById(1L);

        // Verificar se o método deleteById foi chamado com o ID correto
        verify(educacaoRepository).deleteById(1L);
    }
}
