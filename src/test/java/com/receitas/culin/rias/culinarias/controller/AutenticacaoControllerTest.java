package com.receitas.culin.rias.culinarias.controller;

import com.receitas.culin.rias.culinarias.service.TokenService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import static org.mockito.Mockito.mock;

class AutenticacaoControllerTest {

    private Authentication authentication;
    private TokenService tokenService;

    public void ReceitaServiceTest() {

        this.tokenService = mock(TokenService.class);
        this.authentication = mock(Authentication.class);
    }


}