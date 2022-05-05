package com.receitas.culin.rias.culinarias.model;

import com.receitas.culin.rias.culinarias.Tipos;

import javax.persistence.*;

@Entity
@Table(name = "receitas")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private Tipos tipos;

    @ManyToOne
    private Usuario usuario;

    public Receita() {
    }

    public Receita(int id, String nome, String descricao, Tipos tipos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipos = tipos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}





