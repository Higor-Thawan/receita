package com.receitas.culin.rias.service;

import com.receitas.culin.rias.Tipos;
import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.repository.ReceitaRepository;
import com.receitas.culin.rias.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ReceitaServiceTest {

    @InjectMocks
    private ReceitaService service;
    private ReceitaRepository receitaRepository;

    public ReceitaServiceTest() {
        this.service = mock(ReceitaService.class);
        this.receitaRepository = mock(ReceitaRepository.class);
    }

    @Test
    void create() {
        var receita = new Receita(1, "Higor", "estagiario", Tipos.PRINCIPAL);
    doNothing().when(service).create(any(Receita.class), anyLong());
    }

    @Test
    void findAll() {
        var receita = new Receita(1, "Higor", "estagiario", Tipos.PRINCIPAL);
        List<Receita> receitas = Arrays.asList(
        receita
        );
        when(service.findAll()).thenReturn(receitas);

        var receita1 = service.findAll();
        assertNotNull(receita1);
    }

    @Test
    void findById() {


    }

    @Test
    void updateSucess() {
        Usuario usuario = new Usuario();
        usuario.setEmail("Teste");
        usuario.setEmail("teste@gmail.com");

    }

    @Test
    void updateFail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("Teste");
        usuario.setEmail("teste");

    }

    @Test
    void delete() {
        receitaRepository.deleteAll();
    }
}