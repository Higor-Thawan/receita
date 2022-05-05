package com.receitas.culin.rias.culinarias.controller;

import com.receitas.culin.rias.culinarias.model.Receita;
import com.receitas.culin.rias.culinarias.model.Usuario;
import com.receitas.culin.rias.culinarias.service.ReceitaService;
import com.receitas.culin.rias.culinarias.service.UsuarioService;
import com.receitas.culin.rias.culinarias.controller.exceptions.ExceptionsController;
import com.receitas.culin.rias.culinarias.dto.ReceitaDto;
import com.receitas.culin.rias.culinarias.exceptions.NotFoundException;
import com.receitas.culin.rias.culinarias.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private ReceitaService receitaService;
    private UsuarioService usuarioService;
    private AuthenticationManager authmanager;
    private TokenService tokenService;
    private Usuario usuarios;

    @Autowired
    public Controller(ReceitaService receitaService, UsuarioService usuarioService, AuthenticationManager authmanager, TokenService tokenService) {
        this.receitaService = receitaService;
        this.usuarioService = usuarioService;
        this.authmanager = authmanager;
        this.tokenService = tokenService;
    }

    @PostMapping("/receita")
    public ResponseEntity create(@RequestBody Receita receitas, @RequestHeader("authorization") String token) {

        String tokenHash = token.split( " ")[1];

        Long idUsuario = tokenService.getIdUsuario(tokenHash);

        receitaService.create(receitas, idUsuario);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/receita")
    public ResponseEntity findAll() {
        try {
            var receitas = receitaService.findAll();
            return ResponseEntity.ok(ReceitaDto.converterList(receitas));
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionsController(HttpStatus.NOT_FOUND, ex.getMessage()));
        }

    }

    @GetMapping("/receita/{id}")
    public ResponseEntity findByIdReceita(@PathVariable String id) {
        try {
            var receitas = receitaService.findById(Integer.parseInt(id));
            return ResponseEntity.ok(ReceitaDto.converter(receitas));
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionsController(HttpStatus.NOT_FOUND, ex.getMessage()));
        }
    }

    @PutMapping("/receita/{id}")
    public ResponseEntity<Receita> updateReceita(@PathVariable String id, @RequestBody Receita receita) {

        return ResponseEntity.ok(receitaService.update(Integer.parseInt(id), receita));
    }

    @DeleteMapping("/receita/{id}")
    public  ResponseEntity deleteReceita(@PathVariable String id, Receita receita) {

        receitaService.delete(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/usuario")
    public ResponseEntity createUsuario(@RequestBody Usuario usuario) {

        usuarioService.create(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> findAllUsuario() {

        return ResponseEntity.ok(usuarioService.findAll());
    }


    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String id, @RequestBody Usuario usuario) {

        return ResponseEntity.ok(usuarioService.update(Long.parseLong(id), usuario));
    }

    @DeleteMapping("/usuario/{id}")
    public  ResponseEntity deleteUsuario(@PathVariable String id, Usuario usuario) {

        usuarioService.delete(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

}
