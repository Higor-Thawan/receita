package com.receitas.culin.rias.culinarias.repository;

import com.receitas.culin.rias.culinarias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

    Optional<Usuario>findByEmail(String email);


}

