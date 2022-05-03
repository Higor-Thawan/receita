package com.receitas.culin.rias.service;

import com.receitas.culin.rias.Tipos;
import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.repository.ReceitaRepository;
import com.receitas.culin.rias.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ReceitaServiceTest {

    private final ReceitaRepository receitaRepository;
    private final UsuarioRepository userRepository;
    private final ReceitaService receitaService;

    public ReceitaServiceTest() {

        this.receitaRepository = mock(ReceitaRepository.class);
        this.userRepository = mock(UsuarioRepository.class);
        this.receitaService = mock(ReceitaService.class);
    }

    @Test
    void deveCriarUmaReceita() {
        var receita = new Receita(1, "Higor", "estagiario", Tipos.PRINCIPAL);
        var usuario = new Usuario(1L, "teste", "teste@teste.com", "123");
        Optional<Usuario> usuario1 = Optional.of(usuario);
        Mockito.doReturn(usuario1).when(this.userRepository).findById(anyLong());
        var service = new ReceitaService(this.receitaRepository, this.userRepository);

        service.create(receita, 1L);
        verify(receitaRepository, times(1)).save(any(Receita.class));
    }

    @Test
    void findAllReceita() {
        var receita = new Receita(1, "Maça doce", "doce feito uma Maça", Tipos.SOBREMESA);
        List<Receita> receitas = List.of(receita);
        Mockito.doReturn(receitas).when(this.receitaRepository).findAll();
        var service = new ReceitaService(this.receitaRepository, this.userRepository);
        var receitas1 = service.findAll();
        assertNotNull(receitas1);
    }

    @Test
    void deveRetornarUmaReceita() {
        var receita = new Receita(1, "Higor", "estagiario", Tipos.PRINCIPAL);
        Optional<Receita> receita1 = Optional.of(receita);
        Mockito.doReturn(receita1).when(this.receitaRepository).findById(anyInt());
        var service = new ReceitaService(this.receitaRepository, this.userRepository);
        var receita2 = service.findById(1);
        assertNotNull(receita2);
        verify(receitaRepository, times(1)).findById(anyInt());
    }

    @Test
    void updateSucess() {
        var receita = new Receita(1, "teste", "teste e mais teste", Tipos.PETISCO);
        var service = new ReceitaService(this.receitaRepository, this.userRepository);
        var receita2 = service.update(1, receita);
        Optional<Receita> receita1 = Optional.of(receita);
        Mockito.doReturn(receita1).when(this.receitaRepository).findById(anyInt());
        assertNotNull(receita2);
    }

    @Test
    void delete() {
        var receita = Optional.of(new Receita(1, "Higor", "estagiario", Tipos.PRINCIPAL));
        Mockito.doReturn(receita).when(this.receitaRepository).findById(anyInt());
        var service = new ReceitaService(this.receitaRepository, this.userRepository);
        service.delete(1);
        verify(receitaRepository, times(1)).deleteById(anyInt());
    }
}