package com.example.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown when a specific sweet resource cannot be found.
 * <p>
 * This exception is annotated with {@code @ResponseStatus(HttpStatus.NOT_FOUND)},
 * which causes Spring to automatically return a 404 Not Found HTTP status
 * when this exception is thrown from a controller.
 */
@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SweetsNotFoundException extends RuntimeException {

    /**
     * The name of the resource that was not found (e.g., "Sweet").
     */
    private String resourceName;

    /**
     * The name of the field that was used for the search (e.g., "id").
     */
    private String fieldName;

    /**
     * The value of the field that was used for the search (e.g., "abc-123").
     */
    private String fieldValue;


    /**
     * Constructs a new SweetsNotFoundException with a detailed message for a specific query.
     * Example: "Sweet not found with id: abc-123".
     *
     * @param resourceName The name of the resource.
     * @param fieldName    The name of the field used in the search.
     * @param fieldValue   The value of the field that was not found.
     */
    public SweetsNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    /**
     * Constructs a new SweetsNotFoundException with a more generic message.
     * Example: "The particular Sweet couldn't be found in the inventory".
     *
     * @param resourceName The name of the resource.
     */
    public SweetsNotFoundException(String resourceName) {
        super(String.format("The particular %s couldn't be found in the inventory ", resourceName));
        this.resourceName = resourceName;
    }
}