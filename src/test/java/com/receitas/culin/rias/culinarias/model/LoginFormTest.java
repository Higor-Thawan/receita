package com.receitas.culin.rias.culinarias.model;

import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LoginFormTest {

    @Test
    void createObjectLoginForm() {
        LoginForm usuario1 = new LoginForm();
        usuario1.setEmail("teste@gmail.com");
        usuario1.setSenha("12345");
        assertEquals("teste@gmail.com", usuario1.getEmail());
        assertEquals("12345", usuario1.getSenha());
    }

    @Test
    void createObjectConverter() {
        LoginForm usuario2 = new LoginForm();
        usuario2.setEmail("teste@teste.com");
        usuario2.setSenha("123");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario2.getEmail(), usuario2.getSenha());
        assertEquals(token, usuario2.converter());
    }

}