package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a sweet entity in the database.
 * This class is mapped to the "sweets" table.
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "sweets")
public class Sweets {

    /**
     * The unique identifier for the sweet.
     * It is automatically generated as a UUID string.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * The name of the sweet (e.g., "Gulab Jamun").
     */
    @Column(name = "name")
    private String name;

    /**
     * The category the sweet belongs to (e.g., "Traditional", "Cake").
     */
    @Column(name = "category")
    private String category;

    /**
     * The price of a single unit of the sweet.
     */
    @Column(name = "price")
    private Double price;

    /**
     * The available stock or quantity of the sweet.
     */
    @Column(name = "quantity")
    private Integer quantity;

    /**
     * Convenience constructor to create a new sweet instance.
     * The ID is not included as it will be generated automatically upon persistence.
     *
     * @param name     The name of the sweet.
     * @param category The category of the sweet.
     * @param price    The price of the sweet.
     * @param quantity The available quantity.
     */
    public Sweets(String name, String category, Double price, Integer quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
}