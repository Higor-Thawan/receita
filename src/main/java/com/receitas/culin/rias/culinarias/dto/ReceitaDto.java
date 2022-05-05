package com.receitas.culin.rias.culinarias.dto;

import com.receitas.culin.rias.culinarias.model.Receita;
import com.receitas.culin.rias.culinarias.Tipos;

import java.util.List;
import java.util.stream.Collectors;

public class ReceitaDto {

    private int idReceita;
    private String nomeReceita;
    private String descricaoReceita;
    private Tipos tiposReceita;
    private Long idUsuario;
    private String nomeUsuario;
    private String emailUsuario;


    public ReceitaDto(int idReceita, String nomeReceita, String descricaoReceita,
                      Tipos tiposReceita, Long idUsuario, String nomeUsuario, String emailUsuario) {
        this.idReceita = idReceita;
        this.nomeReceita = nomeReceita;
        this.descricaoReceita = descricaoReceita;
        this.tiposReceita = tiposReceita;
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
    }

    public static ReceitaDto converter(Receita receita) {
        return new ReceitaDto(receita.getId(), receita.getNome(), receita.getDescricao(),
                receita.getTipos(), receita.getUsuario().getId(), receita.getUsuario().getNome(), receita.getUsuario().getEmail());
    }

    public static List<ReceitaDto> converterList(List<Receita> receitas) {
        return receitas.stream().map(receita -> ReceitaDto.converter(receita)).collect(Collectors.toList());
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getNomeReceita() {
        return nomeReceita;
    }

    public void setNomeReceita(String nomeReceita) {
        this.nomeReceita = nomeReceita;
    }

    public String getDescricaoReceita() {
        return descricaoReceita;
    }

    public void setDescricaoReceita(String descricaoReceita) {
        this.descricaoReceita = descricaoReceita;
    }

    public Tipos getTiposReceita() {
        return tiposReceita;
    }

    public void setTiposReceita(Tipos tiposReceita) {
        this.tiposReceita = tiposReceita;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

}
