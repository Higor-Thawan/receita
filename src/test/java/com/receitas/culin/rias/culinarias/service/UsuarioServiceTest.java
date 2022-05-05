package com.receitas.culin.rias.culinarias.service;

import com.receitas.culin.rias.culinarias.repository.UsuarioRepository;
import com.receitas.culin.rias.culinarias.model.Usuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {


   private final UsuarioRepository usuarioRepository;
   private final PasswordEncoder passwordEncoder;

    UsuarioServiceTest() {

        this.usuarioRepository = mock(UsuarioRepository.class);
        this.passwordEncoder = mock(PasswordEncoder.class);
    }

    @Test
    void createUsuarios() {
       var usuario = new Usuario(1L, "teste", "teste@teste.com", "123");
       Optional<Usuario> usuario1 = Optional.of(usuario);
       Mockito.doReturn(usuario1).when(this.usuarioRepository).findByEmail(anyString());
       var service = new UsuarioService(this.usuarioRepository, this.passwordEncoder);
       service.create(usuario);
       verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void findAllUsuarios() {
        var usuario = new Usuario(1L, "teste", "teste@teste.com", "123");
        List<Usuario> usuarios = List.of(usuario);
        Mockito.doReturn(usuarios).when(this.usuarioRepository).findAll();
        var service = new UsuarioService(this.usuarioRepository, this.passwordEncoder);
        var usuarios1 = service.findAll();
        assertNotNull(usuarios1);
    }

    @Test
    void updateUsuario() {
        var usuario = new Usuario(1L, "teste", "teste@teste.com", "123");
        var service = new UsuarioService(this.usuarioRepository, this.passwordEncoder);
        var usuario1 = service.update(1L, usuario);
        Optional<Usuario> usuario2 = Optional.of(usuario);
        Mockito.doReturn(usuario2).when(this.usuarioRepository).findById(anyLong());
        assertNotNull(usuario2);
    }

    @Test
    void deleteUsuario() {
        var usuario = Optional.of(new Usuario(1L, "teste", "teste@teste.com", "123"));
        Mockito.doReturn(usuario).when(this.usuarioRepository).findById(anyLong());
        var service = new UsuarioService(this.usuarioRepository, this.passwordEncoder);
        service.delete(1);
        verify(usuarioRepository, times(1)).deleteById(anyLong());

    }

}