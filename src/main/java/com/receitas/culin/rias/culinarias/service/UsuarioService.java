package com.receitas.culin.rias.culinarias.service;

import com.receitas.culin.rias.culinarias.exceptions.BadRequestException;
import com.receitas.culin.rias.culinarias.exceptions.NotFoundException;
import com.receitas.culin.rias.culinarias.helpers.EmailValidation;
import com.receitas.culin.rias.culinarias.model.Usuario;
import com.receitas.culin.rias.culinarias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
    }

    public void create(Usuario usuarios) {

        if (!EmailValidation.validation(usuarios.getEmail()))
            throw new BadRequestException("Email invalido");
        usuarios.setSenha(passwordEncoder.encode(usuarios.getPassword()));

        usuarioRepository.save(usuarios);

    }

    public List<Usuario> findAll() {

        var usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new NotFoundException("Usuario nao encontrado");
        }
        return usuarios;
    }

    @Transactional
    public Usuario update(Long id, Usuario usuario) {

        usuario.setId(id);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Transactional
    public void delete(int id) {

        usuarioRepository.deleteById((long) id);
    }


}
