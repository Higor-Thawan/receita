package com.receitas.culin.rias.service;

import com.receitas.culin.rias.model.Usuario;
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
        var usuario = new Usuario(1L, "teste", "teste@teste.com", "123");
        Usuario usuario1 = usuariologado.getAuthorities().addAll();
    }

    @Test
    void isTokenValido() {

    }

    @Test
    void getIdUsuario() {

    }
}
