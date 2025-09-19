package com.example.repository;


import com.example.entity.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link Sweets} entity.
 * This interface handles all database operations for sweets, providing both standard
 * CRUD functionality and custom query methods.
 */
public interface SweetRepository extends JpaRepository<Sweets, String> {

    /**
     * Finds a single sweet by its unique name.
     * This is a derived query method; Spring Data JPA generates the query automatically.
     *
     * @param name The name of the sweet to search for.
     * @return The {@link Sweets} entity if found, otherwise null.
     */
    Sweets findSweetsByName(String name);

    /**
     * Finds a list of sweets that match a specific price using a custom JPQL query.
     *
     * @param price The price to filter the sweets by.
     * @return A list of {@link Sweets} entities that match the given price.
     */
    @Query("select s from Sweets s where s.price=?1")
    List<Sweets> findSweetsByPrice(Double price);

    /**
     * Finds a list of sweets that belong to a specific category using a custom JPQL query.
     *
     * @param category The category to filter the sweets by.
     * @return A list of {@link Sweets} entities that match the given category.
     */
    @Query("select c from Sweets c where c.category=?1")
    List<Sweets> findSweetsByCategory(String category);

}