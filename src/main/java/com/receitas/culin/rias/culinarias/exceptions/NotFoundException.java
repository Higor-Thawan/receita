package com.receitas.culin.rias.culinarias.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }

}
