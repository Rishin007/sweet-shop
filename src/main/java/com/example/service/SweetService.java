package com.example.service;

import com.example.dto.SweetsDto;

import java.util.List;
import java.util.Optional;

/**
 * Service interface defining the business logic for managing sweets.
 * It outlines the contract for all CRUD (Create, Read, Update, Delete) operations.
 */
public interface SweetService {

    /**
     * Saves a new sweet to the database.
     *
     * @param sweetsDto The DTO containing the data for the new sweet to be created.
     * @return An Optional containing the DTO of the newly created sweet, or an empty Optional if creation fails.
     */
    Optional<SweetsDto> createSweet(SweetsDto sweetsDto);

    /**
     * Retrieves a list of all sweets.
     *
     * @return An Optional containing a list of all sweet DTOs, or an empty Optional if no sweets are found.
     */
    Optional<List<SweetsDto>> getAllSweets();

    /**
     * Finds a sweet by its name.
     *
     * @param name The name of the sweet to search for.
     * @return An Optional containing the DTO of the found sweet, or an empty Optional if no sweet with that name exists.
     */
    Optional<SweetsDto> getSweetByName(String name);

    /**
     * Finds all sweets that match a specific price.
     *
     * @param price The price to filter the sweets by.
     * @return An Optional containing a list of sweet DTOs matching the price, or an empty Optional if none are found.
     */
    Optional<List<SweetsDto>> getSweetByPrice(Double price);

    /**
     * Finds all sweets belonging to a specific category.
     *
     * @param category The category to filter the sweets by.
     * @return An Optional containing a list of sweet DTOs matching the category, or an empty Optional if none are found.
     */
    Optional<List<SweetsDto>> getSweetByCategory(String category);

    /**
     * Updates an existing sweet identified by its ID.
     *
     * @param id        The unique ID of the sweet to be updated.
     * @param sweetsDto The DTO containing the updated data for the sweet.
     * @return An Optional containing the DTO of the updated sweet, or an empty Optional if no sweet with the given ID was found.
     */
    Optional<SweetsDto> updateSweet(String id, SweetsDto sweetsDto);

    /**
     * Deletes a sweet from the database by its ID.
     *
     * @param id The unique ID of the sweet to be deleted.
     * @return An Optional containing a confirmation message upon successful deletion, or an empty Optional if no sweet with the given ID was found.
     */
    Optional<String> deleteSweetById(String id);
}