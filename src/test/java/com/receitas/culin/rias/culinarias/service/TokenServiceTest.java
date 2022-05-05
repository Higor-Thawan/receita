package com.receitas.culin.rias.culinarias.service;

import com.receitas.culin.rias.culinarias.model.Usuario;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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
