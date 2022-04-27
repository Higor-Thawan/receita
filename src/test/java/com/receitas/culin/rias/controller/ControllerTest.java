package com.receitas.culin.rias.controller;

import com.receitas.culin.rias.Tipos;
import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.service.ReceitaService;
import com.receitas.culin.rias.service.TokenService;
import com.receitas.culin.rias.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class ControllerTest {

    @InjectMocks
    private ReceitaService receitaService;
    private UsuarioService usuarioService;
    private AuthenticationManager authmanager;

    @InjectMocks
    private TokenService tokenService;

    public ControllerTest() {
        this.receitaService = mock(ReceitaService.class);
        this.tokenService = mock(TokenService.class);
        this.authmanager = mock(AuthenticationManager.class);
        this.usuarioService = mock(UsuarioService.class);
    }

   /* @Test
    void createReceitaSucess() {
        String token = tokenService.
    }*/

    @Test
    void findAllReceitaSucess() {
        Controller controller  = new Controller(receitaService,usuarioService,authmanager,tokenService);
        var responseEntity= controller.findAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


    @Test
    void findByIdReceitaSucess() {
        Controller controller = new Controller(receitaService, usuarioService, authmanager, tokenService);
        var responseEntity = controller.findByIdReceita(String.valueOf(1L));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void updateReceitaSucess() {
        Receita receita = new Receita(1, "morango", "morango e mais morango", Tipos.SOBREMESA);
        Controller controller = new Controller(receitaService, usuarioService,authmanager,tokenService);
        var responseEntity = controller.updateReceita("1", receita);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void deleteReceitaSucess() {
        Receita receita = new Receita(1, "morango", "morango e mais morango", Tipos.SOBREMESA);
        Controller controller = new Controller(receitaService, usuarioService, authmanager, tokenService);
        var responseEntity = controller.deleteReceita("1", receita);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    /*@Test
    * void createUsuarioSucess() {}*/

    @Test
    void findAllUsuarioSucess() {
        Controller controller  = new Controller(receitaService,usuarioService,authmanager,tokenService);
        var responseEntity= controller.findAll();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void findByIdUsuarioSucess() {
        Controller controller = new Controller(receitaService, usuarioService, authmanager, tokenService);
        var responseEntity = controller.findByIdReceita(String.valueOf(1L));
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void updateUsuarioSucess() {
        Usuario usuario = new Usuario(1, "teste", "teste@teste.com", "123");
        Controller controller = new Controller(receitaService, usuarioService,authmanager,tokenService);
        var responseEntity = controller.updateUsuario("1", usuario);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void deleteUsuarioSucess() {
        Usuario usuario = new Usuario(1, "teste", "teste@teste.com", "123");
        Controller controller = new Controller(receitaService, usuarioService, authmanager, tokenService);
        var responseEntity = controller.deleteUsuario("1", usuario);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}