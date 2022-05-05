package com.receitas.culin.rias.culinarias.controller.exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionsController {

    private long timestamp;
    private int status;
    private HttpStatus error;
    private List<String> erros;

    public long getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }
    public HttpStatus getError() {
        return error;
    }

    public List<String> getErros() {
        return erros;
    }

    public ExceptionsController(HttpStatus error, String mensagem) {
        this.error = error;
        this.timestamp = Instant.now().getEpochSecond();
        this.status = error.value();
        this.erros = Arrays.asList(mensagem);
    }
}
