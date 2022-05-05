package com.receitas.culin.rias.culinarias.repository;

import com.receitas.culin.rias.culinarias.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
}