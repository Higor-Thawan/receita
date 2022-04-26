package com.receitas.culin.rias.controller;

import ch.qos.logback.core.subst.Token;
import com.receitas.culin.rias.Tipos;
import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.service.ReceitaService;
import com.receitas.culin.rias.service.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ControllerTest {

    @InjectMocks
    private ReceitaService receitaService;

    @InjectMocks
    private TokenService tokenService;

    @InjectMocks
    private Controller controller;

    public ControllerTest() {
        this.receitaService = mock(ReceitaService.class);
        this.tokenService = mock(TokenService.class);
        this.controller = mock(Controller.class);
    }

   /* @Test
    void createReceitaSucess() {
        String token = tokenService.
    }*/

    @Test
    void findAllSucess() {
        var receita = new Receita(1, "teste", "testando", Tipos.PRINCIPAL);
        List<Receita> receitas = Arrays.asList(
                receita
        );

        var responseEntity= controller.findAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}