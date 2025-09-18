package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SweetNotCreatedException extends RuntimeException {
        private String resourceName;


    public SweetNotCreatedException(String resourceName) {
        super(String.format("Oops! The %s could not be created ", resourceName));
        this.resourceName = resourceName;

    }
}
