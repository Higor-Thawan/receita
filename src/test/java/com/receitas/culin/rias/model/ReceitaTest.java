package com.receitas.culin.rias.model;

import com.receitas.culin.rias.Tipos;
import org.junit.jupiter.api.Test;

import static com.receitas.culin.rias.Tipos.SOBREMESA;
import static org.junit.jupiter.api.Assertions.*;

class ReceitaTest {

    @Test
    void createObjectReceita() {
        Receita receita1 = new Receita();
        receita1.setId(1);
        receita1.setNome("Doce de morango");
        receita1.setDescricao("Morangos, sorvete e creme");
        receita1.setTipos(Tipos.valueOf(String.valueOf(SOBREMESA)));
        assertEquals(1, receita1.getId());
        assertEquals("Doce de morango", receita1.getNome());
        assertEquals("Morangos, sorvete e creme", receita1.getDescricao());
        assertEquals(SOBREMESA, receita1.getTipos());
    }

    @Test
    void createObjectUsuario() {
        Receita usuario = new Receita();
        Usuario usuario1 = new Usuario();
        usuario.setUsuario(usuario1);
        usuario1.setEmail("teste@teste.com");
        usuario1.setSenha("12345");
        usuario1.setId(1L);
        usuario1.setNome("Teste");
        assertEquals("Teste", usuario.getUsuario().getNome());
    }

}