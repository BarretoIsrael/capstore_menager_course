package com.barreto.developer.capstroremenager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CapNotFoundException extends Exception {
    public CapNotFoundException(Long id) {
        super(String.format("Cap with Id not found", id));
    }
}
