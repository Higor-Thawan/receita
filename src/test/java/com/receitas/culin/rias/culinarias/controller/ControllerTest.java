package com.receitas.culin.rias.culinarias.controller;

import com.receitas.culin.rias.culinarias.model.Receita;
import com.receitas.culin.rias.culinarias.model.Usuario;
import com.receitas.culin.rias.culinarias.service.ReceitaService;
import com.receitas.culin.rias.culinarias.service.UsuarioService;
import com.receitas.culin.rias.culinarias.Tipos;
import com.receitas.culin.rias.culinarias.service.TokenService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

class ControllerTest {

    @InjectMocks
    private ReceitaService receitaService;

    private UsuarioService usuarioService;
    private AuthenticationManager authmanager;

    @InjectMocks
    private TokenService tokenService;
    private Receita receita;

    public ControllerTest() {
        this.receitaService = mock(ReceitaService.class);
        this.tokenService = mock(TokenService.class);
        this.authmanager = mock(AuthenticationManager.class);
        this.usuarioService = mock(UsuarioService.class);
    }

    @Test
    void createReceitaSucess() {
        Receita receita = new Receita(1, "morango", "morango e mais morango", Tipos.SOBREMESA);

        String token= "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwiaWQiOiIyIiwiaWF0IjoxNTE2MjM5MDIyfQ.KO4UMOBU8FXfoS5uWxJ46hXPDd9ba4gag6mB1LOI6xw";

        Controller controller = new Controller(receitaService,usuarioService,authmanager,tokenService);
        var response = controller.create(receita,token);

        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

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

    @Test
    void createUsuarioSucess() {
        Usuario usuario = new Usuario(1, "teste", "teste@teste.com", "123");
        Controller controller  = new Controller(receitaService,usuarioService,authmanager,tokenService);
        var responseEntity = controller.createUsuario(usuario);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void findAllUsuarioSucess() {
        Controller controller  = new Controller(receitaService,usuarioService,authmanager,tokenService);
        var responseEntity= controller.findAllUsuario();
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