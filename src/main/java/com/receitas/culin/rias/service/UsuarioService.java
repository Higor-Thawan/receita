package com.receitas.culin.rias.service;

import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void create(Usuario usuarios) {

            usuarios.setSenha(passwordEncoder.encode(usuarios.getPassword()));

        usuarioRepository.save(usuarios);

    }

    public List<Usuario> findAll() {

        return usuarioRepository.findAll();
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
