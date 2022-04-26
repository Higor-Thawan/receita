package com.receitas.culin.rias.model;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import static org.hibernate.criterion.Projections.id;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void createObjectUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setId(1L);
        usuario.setSenha("1234");
        usuario.setEmail("teste@teste.com");
        assertEquals("Teste", usuario.getNome());
        assertEquals(1, usuario.getId());
        assertEquals("teste@teste.com", usuario.getEmail());
        assertEquals("teste@teste.com", usuario.getUsername());
        assertEquals("1234", usuario.getSenha());
        assertEquals("1234", usuario.getPassword());
    }

    @Test
    void createObjectConstrutorSucess() {
       Usuario usuario = new Usuario(1, "Teste", "teste@teste.com", "1234");
       assertNotNull(usuario);
    }

    @Test
    void createObjectConstrutorFail() {
        Usuario usuario = new Usuario();
        assertNull(usuario.getNome());
        assertNull(usuario.getSenha());
        assertNull(usuario.getId());
        assertNull(usuario.getEmail());
    }

}