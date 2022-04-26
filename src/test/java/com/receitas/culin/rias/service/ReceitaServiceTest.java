package com.receitas.culin.rias.service;

import com.receitas.culin.rias.Tipos;
import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.repository.ReceitaRepository;
import com.receitas.culin.rias.repository.UsuarioRepository;
import com.receitas.culin.rias.service.ReceitaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ReceitaServiceTest {

    @InjectMocks
    private ReceitaService service;

    private ReceitaRepository receitaRepository;
    private UsuarioRepository userRepository;

    public ReceitaServiceTest() {

        this.service = mock(ReceitaService.class);
        this.receitaRepository = mock(ReceitaRepository.class);
        this.userRepository = mock(UsuarioRepository.class);
    }

    @Test
    void deveCriarUmaReceita() {
        var receita = new Receita(1, "Higor", "estagiario", Tipos.PRINCIPAL);
        doNothing().when(service).create(any(Receita.class), anyLong());
    }

    @Test
    void deveRetornarUmaReceita() {
        var receita = new Receita(1, "Higor", "estagiario", Tipos.PRINCIPAL);
        List<Receita> receitas = Arrays.asList(
        receita
        );
        when(service.findAll()).thenReturn(receitas);

        var receita1 = service.findAll();
        assertNotNull(receita1);
    }

    @Test
    void deveRetornarUmaReceita_QuandoSucesso() {
        var receita = receitaTest();
        Mockito.when(service.findById(Mockito.anyInt())).thenReturn(receita);
        Receita receita2 = service.findById(1);
        Assertions.assertNotNull(receita2);
    }

    @Test
    void updateSucess() {
        var receita = receitaTest();
        when(service.update(anyInt(),any(Receita.class))).thenReturn(receita);

    }

    @Test
    void updateFail() {
        var receita = receitaTest();
        when(service.update(anyInt(),any(Receita.class))).thenReturn(null);
    }

    @Test
    void delete() {
            receitaRepository.deleteById(1);
            Mockito.verify(receitaRepository).deleteById(1);
    }

    private void startUser() {
        Usuario user = new Usuario(1, "higor", "higor@gmail.com", "12345");
    }

    private Receita receitaTest() {
        Receita receita = new Receita(1, "Maça", "vermelha e docinha", Tipos.PETISCO);
        return receita;
    }
}