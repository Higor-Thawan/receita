package com.receitas.culin.rias.service;

import com.receitas.culin.rias.model.Receita;
import com.receitas.culin.rias.model.Usuario;
import com.receitas.culin.rias.repository.ReceitaRepository;
import com.receitas.culin.rias.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void create(Receita receitas) {

        Usuario usuario = usuarioRepository.findById((long) receitas.getIdUsuario()).get();
        receitas.setUsuario(usuario);
        receitaRepository.save(receitas);

    }

    public List<Receita> findAll(){

       return receitaRepository.findAll();

    }


    public Receita findById(int id) {

        return receitaRepository.findById(id).get();

    }

    @Transactional
    public Receita update(int id, Receita receita) {

        receita.setId(id);
        receitaRepository.save(receita);
        return receita;
    }

    @Transactional
    public void delete(int id) {

        receitaRepository.deleteById(id);
    }

}