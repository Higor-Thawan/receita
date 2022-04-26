package com.receitas.culin.rias.service;

import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.service.TokenService;
import com.receitas.culin.rias.service.UsuarioService;
import org.apache.el.parser.Token;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TokenServiceTest {

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private UsuarioService usuarioService;

    private String gerarTokenTeste;
    private String validarCampos;
    private String save;
    private Usuario usuariologado;


    @Test
    void gerarTokenSucess() {
    }

    @Test
    void isTokenValido() {

    }

    @Test
    void getIdUsuario() {

    }
}
