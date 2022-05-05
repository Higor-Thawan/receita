package com.receitas.culin.rias.culinarias.service;

import com.receitas.culin.rias.culinarias.repository.ReceitaRepository;
import com.receitas.culin.rias.culinarias.repository.UsuarioRepository;
import com.receitas.culin.rias.culinarias.exceptions.NotFoundException;
import com.receitas.culin.rias.culinarias.model.Receita;
import com.receitas.culin.rias.culinarias.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReceitaService {

    private ReceitaRepository receitaRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
        public ReceitaService(ReceitaRepository receitaRepository, UsuarioRepository usuarioRepository) {
        this.receitaRepository = receitaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void create(Receita receitas, Long idUsario) {

        Usuario usuario = usuarioRepository.findById(idUsario).get();
        receitas.setUsuario(usuario);
        receitaRepository.save(receitas);

    }

    public List<Receita> findAll(){

       var receitas = receitaRepository.findAll();
       if (receitas.isEmpty()) {
           throw new NotFoundException("Nao foi encontrada a receita");
       }
       return receitas;
    }

    public Receita findById(int id) {
        return receitaRepository.findById(id).orElseThrow(()-> new NotFoundException("ID da receita, nao foi encontrado"));
    }

    @Transactional
    public Receita update(int id, Receita receita) {

        receita.setId(id);
        receitaRepository.save(receita);
        return receita;
    }

    @Transactional
    public void delete(int id) {
        var receita = findById(id);
        if (receita != null)
            receitaRepository.deleteById(id);
    }

}
