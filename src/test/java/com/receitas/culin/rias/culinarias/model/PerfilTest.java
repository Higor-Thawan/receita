package com.receitas.culin.rias.culinarias.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerfilTest {

    @Test
    void createObjectPerfil() {
        Perfil usuario = new Perfil();
        usuario.setNome("teste");
        usuario.setId(Long.valueOf("1"));
        assertEquals("teste", usuario.getNome());
        assertEquals(1, usuario.getId());

    }

    @Test
    void createObjectAuthority() {
        Perfil authority = new Perfil();
        authority.setNome("teste");
        authority.setId(1L);
        assertEquals("teste", authority.getAuthority());

    }
}