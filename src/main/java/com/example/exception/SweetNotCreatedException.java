package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown when a new sweet resource cannot be created.
 * <p>
 * This exception is annotated with {@code @ResponseStatus(HttpStatus.BAD_REQUEST)},
 * which causes Spring to automatically return a 400 Bad Request HTTP status
 * when this exception is thrown from a controller.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SweetNotCreatedException extends RuntimeException {

    /**
     * The name of the resource that failed to be created (e.g., "Sweet").
     */
    private String resourceName;

    /**
     * Constructs a new SweetNotCreatedException with a formatted error message.
     *
     * @param resourceName The name of the resource that could not be created.
     */
    public SweetNotCreatedException(String resourceName) {
        super(String.format("Oops! The %s could not be created ", resourceName));
        this.resourceName = resourceName;
    }
}