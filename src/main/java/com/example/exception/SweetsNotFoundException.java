package com.example.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SweetsNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String fieldValue;


    public SweetsNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    public SweetsNotFoundException(String resourceName) {
        super(String.format("The particular %s couldn't be found in the inventory ", resourceName));
        this.resourceName = resourceName;

    }
}
