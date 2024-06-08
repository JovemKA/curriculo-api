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

import com.example.curriculo_api.model.Perfil;

@RunWith(MockitoJUnitRunner.class)
public class PerfilRepositoryTest {

    @Mock
    private PerfilRepository perfilRepository;

    // Remove the unused variable

    @Test
    public void testFindById() {
        // Criar um objeto Perfil simulado
        Perfil simulatedPerfil = new Perfil();
        simulatedPerfil.setId(1L);
        simulatedPerfil.setName("Nome Sobrenome");
        simulatedPerfil.setEmail("email@example.com");

        // Simular o comportamento do repositório
        when(perfilRepository.findById(1L)).thenReturn(Optional.of(simulatedPerfil));

        // Chamar o método do repositório
        Optional<Perfil> result = perfilRepository.findById(1L);

        // Verificar se o resultado é o esperado
        assertEquals(simulatedPerfil, result.get());
    }

    @Test
    public void testSavePerfil() {
        // Criar um objeto Perfil simulado
        Perfil simulatedPerfil = new Perfil();
        simulatedPerfil.setId(1L);
        simulatedPerfil.setName("Nome Sobrenome");
        simulatedPerfil.setEmail("email@example.com");

        // Simular o comportamento do repositório
        when(perfilRepository.save(any(Perfil.class))).thenReturn(simulatedPerfil);

        // Chamar o método de salvar do repositório
        Perfil savedPerfil = perfilRepository.save(simulatedPerfil);

        // Verificar se o objeto retornado é o mesmo que foi salvo
        assertEquals(simulatedPerfil, savedPerfil);
    }

    @Test
    public void testUpdatePerfil() {
        // Criar um objeto Perfil simulado
        Perfil simulatedPerfil = new Perfil();
        simulatedPerfil.setId(1L);
        simulatedPerfil.setName("Nome Sobrenome");
        simulatedPerfil.setEmail("email@example.com");

        // Simular o comportamento do repositório
        when(perfilRepository.save(any(Perfil.class))).thenReturn(simulatedPerfil);

        // Chamar o método de atualizar do repositório
        Perfil updatedPerfil = perfilRepository.save(simulatedPerfil);

        // Verificar se o objeto retornado é o mesmo que foi atualizado
        assertEquals(simulatedPerfil, updatedPerfil);
    }

    @Test
    public void testDeletePerfil() {
        // Chamar o método de deletar do repositório
        perfilRepository.deleteById(1L);

        // Verificar se o método deleteById foi chamado com o ID correto
        verify(perfilRepository).deleteById(1L);
    }
}
