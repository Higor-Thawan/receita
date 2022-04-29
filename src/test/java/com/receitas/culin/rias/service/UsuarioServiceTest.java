package com.receitas.culin.rias.service;

import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void SaveUserSucess() {
        final Usuario usuario = new Usuario(1, "teste", "teste@teste.com", "123");

    }

}