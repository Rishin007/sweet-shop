package com.example.exception;

/**
 * Custom exception thrown when a search for a list of sweets yields no results.
 * <p>
 * This is typically used when a query for all sweets is made, but the database
 * table is empty or no items match the criteria. Note that without a
 * {@code @ResponseStatus} annotation or a dedicated {@code @ControllerAdvice} handler,
 * this exception will likely result in a 500 Internal Server Error response.
 */
public class ListOfSweetsNotFoundException extends RuntimeException {

    /**
     * Constructs a new ListOfSweetsNotFoundException with a specific error message.
     *
     * @param message The detail message explaining the reason for the exception
     * (e.g., "No List of Sweets Found").
     */
    public ListOfSweetsNotFoundException(String message) {
        super(message);
    }
}