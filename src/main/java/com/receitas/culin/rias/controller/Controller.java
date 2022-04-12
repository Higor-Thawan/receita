package com.receitas.culin.rias.controller;

import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.service.ReceitaService;
import com.receitas.culin.rias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ReceitaService receitaService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/receita")
    public ResponseEntity create(@RequestBody Receita receitas) {

        receitaService.create(receitas);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/receita")
    public ResponseEntity<List<Receita>> findAll() {

        return ResponseEntity.ok(receitaService.findAll());

    }

    @GetMapping("/receita/{id}")
    public ResponseEntity<Receita> findByIdReceita(@PathVariable String id) {

        return ResponseEntity.ok(receitaService.findById(Integer.parseInt(id)));
    }

    @PutMapping("/receita/{id}")
    public ResponseEntity<Receita> updateReceita(@PathVariable String id, @RequestBody Receita receita) {

        return ResponseEntity.ok(receitaService.update(Integer.parseInt(id), receita));
    }

    @DeleteMapping("/receita/{id}")
    public  ResponseEntity deleteReceita(@PathVariable String id) {

        receitaService.delete(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/usuario")
    public ResponseEntity createUsuario(@RequestBody Usuario usuarios) {

        usuarioService.create(usuarios);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> findAllUsuario() {

        return ResponseEntity.ok(usuarioService.findAll());
    }


    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String id, @RequestBody Usuario usuario) {

        return ResponseEntity.ok(usuarioService.update(Integer.parseInt(id), usuario));
    }

    @DeleteMapping("/usuario/{id}")
    public  ResponseEntity deleteUsuario(@PathVariable String id) {

        usuarioService.delete(Integer.parseInt(id));
        return ResponseEntity.ok().build();
    }

}
