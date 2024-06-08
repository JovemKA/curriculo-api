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

import com.example.curriculo_api.model.Experiencia;

@RunWith(MockitoJUnitRunner.class)
public class ExperienciaRepositoryTest {

    @Mock
    private ExperienciaRepository experienciaRepository;

    // Remove the unused variable
    // @InjectMocks
    // private Experiencia experiencia;

    @Test
    public void testFindById() {
        // Criar um objeto Experiencia simulado
        Experiencia simulatedExperiencia = new Experiencia();
        simulatedExperiencia.setId(1L);
        simulatedExperiencia.setPosition("Desenvolvedor");
        simulatedExperiencia.setCompany("Empresa X");
    
        // Simular o comportamento do repositório
        when(experienciaRepository.findById(1L)).thenReturn(Optional.of(simulatedExperiencia));
    
        // Chamar o método do repositório
        Optional<Experiencia> result = experienciaRepository.findById(1L);
    
        // Verificar se o resultado é o esperado
        assertEquals(simulatedExperiencia, result.get());
    }

    @Test
    public void testSaveExperiencia() {
        // Criar um objeto Experiencia simulado
        Experiencia simulatedExperiencia = new Experiencia();
        simulatedExperiencia.setId(1L);
        simulatedExperiencia.setPosition("Desenvolvedor");
        simulatedExperiencia.setCompany("Empresa X");
    
        // Simular o comportamento do repositório
        when(experienciaRepository.save(any(Experiencia.class))).thenReturn(simulatedExperiencia);
    
        // Chamar o método de salvar do repositório
        Experiencia savedExperiencia = experienciaRepository.save(simulatedExperiencia);
    
        // Verificar se o objeto retornado é o mesmo que foi salvo
        assertEquals(simulatedExperiencia, savedExperiencia);
    }

    @Test
    public void testUpdateExperiencia() {
        // Criar um objeto Experiencia simulado
        Experiencia simulatedExperiencia = new Experiencia();
        simulatedExperiencia.setId(1L);
        simulatedExperiencia.setPosition("Desenvolvedor");
        simulatedExperiencia.setCompany("Empresa X");
    
        // Simular o comportamento do repositório
        when(experienciaRepository.save(any(Experiencia.class))).thenReturn(simulatedExperiencia);
    
        // Chamar o método de atualizar do repositório
        Experiencia updatedExperiencia = experienciaRepository.save(simulatedExperiencia);
    
        // Verificar se o objeto retornado é o mesmo que foi atualizado
        assertEquals(simulatedExperiencia, updatedExperiencia);
    }

    @Test
    public void testDeleteExperiencia() {
        // Chamar o método de deletar do repositório
        experienciaRepository.deleteById(1L);

        // Verificar se o método deleteById foi chamado com o ID correto
        verify(experienciaRepository).deleteById(1L);
    }
}
