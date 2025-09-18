package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for carrying sweet-related data between the client and server.
 * This class includes validation rules that are checked when receiving requests.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SweetsDto {

    /**
     * The unique identifier of the sweet.
     * This is typically null when creating a new sweet and populated in responses.
     */
    private String id;

    /**
     * The name of the sweet.
     * This field cannot be null.
     */
    @NotNull(message = "Enter a valid Sweet Name")
    private String name;

    /**
     * The category of the sweet (e.g., "Traditional", "Cake").
     * This field cannot be null.
     */
    @NotNull(message = "Please provide a valid category of sweets")
    private String category;

    /**
     * The price of the sweet.
     * The value must be at least 20.
     */
    @NotNull(message = "Price cannot be null!!")
    @Min(value = 20, message = "Minimum price of the sweets should be 20 INR")
    private Double price;

    /**
     * The available quantity or stock of the sweet.
     * The value must be at least 1.
     */
    @NotNull(message = "Please provide a valid quantity")
    @Min(value = 1, message = "Minimum quantity to be entered is 1")
    private Integer quantity;
}