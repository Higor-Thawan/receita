package com.receitas.culin.rias.culinarias.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenDtoTest {

    @Test
    void createObjectToken() {
        TokenDto token = new TokenDto("jgahdbagybfhgysdhy", "Bearer");
        token.setToken("jgahdbagybfhgysdhy");
        token.setTipo("Bearer");
        assertEquals("jgahdbagybfhgysdhy", token.getToken());
        assertEquals("Bearer", token.getTipo());
    }
}