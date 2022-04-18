package com.receitas.culin.rias.service;

import com.receitas.culin.rias.Tipos;
import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.repository.ReceitaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class ReceitaServiceTest {

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
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}