package com.example.curriculo_api.repository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.curriculo_api.model.Habilidade;

@RunWith(MockitoJUnitRunner.class)
public class HabilidadeRepositoryTest {

    @Mock
    private HabilidadeRepository habilidadeRepository;

    // Remove the unused variable
    // @InjectMocks
    // private Habilidade habilidade;

    @Test
    public void testFindById() {
        // Criar um objeto Habilidade simulado
        Habilidade simulatedHabilidade = new Habilidade();
        simulatedHabilidade.setId(1L);
        simulatedHabilidade.setName("Java");
        simulatedHabilidade.setLevel("Avançado");
    
        // Simular o comportamento do repositório
        when(habilidadeRepository.findById(1L)).thenReturn(Optional.of(simulatedHabilidade));
    
        // Chamar o método do repositório
        Optional<Habilidade> result = habilidadeRepository.findById(1L);
    
        // Verificar se o resultado é o esperado
        assertEquals(simulatedHabilidade, result.get());
    }

    @Test
    public void testSaveHabilidade() {
        // Criar um objeto Habilidade simulado
        Habilidade simulatedHabilidade = new Habilidade();
        simulatedHabilidade.setId(1L);
        simulatedHabilidade.setName("Java");
        simulatedHabilidade.setLevel("Avançado");
    
        // Simular o comportamento do repositório
        when(habilidadeRepository.save(any(Habilidade.class))).thenReturn(simulatedHabilidade);
    
        // Chamar o método de salvar do repositório
        Habilidade savedHabilidade = habilidadeRepository.save(simulatedHabilidade);
    
        // Verificar se o objeto retornado é o mesmo que foi salvo
        assertEquals(simulatedHabilidade, savedHabilidade);
    }

    @Test
    public void testUpdateHabilidade() {
        // Criar um objeto Habilidade simulado
        Habilidade simulatedHabilidade = new Habilidade();
        simulatedHabilidade.setId(1L);
        simulatedHabilidade.setName("Java");
        simulatedHabilidade.setLevel("Avançado");
    
        // Simular o comportamento do repositório
        when(habilidadeRepository.save(any(Habilidade.class))).thenReturn(simulatedHabilidade);
    
        // Chamar o método de atualizar do repositório
        Habilidade updatedHabilidade = habilidadeRepository.save(simulatedHabilidade);
    
        // Verificar se o objeto retornado é o mesmo que foi atualizado
        assertEquals(simulatedHabilidade, updatedHabilidade);
    }

    @Test
    public void testDeleteHabilidade() {
        // Chamar o método de deletar do repositório
        habilidadeRepository.deleteById(1L);

        // Verificar se o método deleteById foi chamado com o ID correto
        verify(habilidadeRepository).deleteById(1L);
    }
}
