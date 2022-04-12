package com.receitas.culin.rias.service;

import com.receitas.culin.rias.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${receita.jwt.expiration}")
    private String expiration;

    @Value("${receita.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataexpiration = new Date(hoje.getTime() + expiration );
        return Jwts.builder()
                .setIssuer("Receita")
                .setSubject(String.valueOf(logado.getId()))
                .setIssuedAt(hoje)
                .setExpiration(dataexpiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }
}
