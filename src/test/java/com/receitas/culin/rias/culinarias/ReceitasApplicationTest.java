package com.receitas.culin.rias.culinarias;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ReceitasApplicationTest {

    @Test
    void shouldStartApplication() {
        String[] args = {};
        assertDoesNotThrow(() -> {
            SpringApplication.run(ReceitasApplication.class, args);
        });
    }
}