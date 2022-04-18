package com.receitas.culin.rias;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Tipos {

    DOCE("doce"),
    SALGADO("salgado"),
    ENTRADA("entrada"),
    SALADA("salada"),
    PRINCIPAL("principal"),
    SOPA("sopa"),
    SOBREMESA("sobremesa"),
    PETISCO("petisco"),
    CARNE("carne"),
    AVE("ave");


    private String descricao;

    Tipos(String descricao) {
        this.descricao = descricao;
    }

    public static Tipos fromString(String tipos) {
        var values = Tipos.values();
        var item = Arrays
                .stream(values)
                .filter(o -> o.name().equalsIgnoreCase(tipos))
                .collect(Collectors.toList());

        if (!item.isEmpty()) return item.get(0);

        return null;
    }

    public String getDescricao() {
        return descricao;
    }

}
