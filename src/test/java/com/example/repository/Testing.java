package com.example.repository;

import com.example.dto.SweetsDto;
import com.example.entity.Sweets;
import com.example.repository.SweetRepository;
import com.example.service.SweetService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BDD-style Integration Tests for the SweetService.
 * <p>
 * These tests use a real in-memory H2 database to verify the interaction
 * between the service and the persistence layer, without using mocks.
 * Each test is transactional to ensure a clean state for every scenario.
 */
@SpringBootTest
@Transactional
class SweetsServiceIntegrationTest {

    @Autowired
    private SweetService sweetService;

    @Autowired
    private SweetRepository sweetRepository;

    private Sweets savedSweet1;
    private Sweets savedSweet2;

    // --- GIVEN ---
    // Setup initial state before each test
    @BeforeEach
    void setUpDatabase() {
        // Given: The database contains some initial sweets
        savedSweet1 = sweetRepository.save(new Sweets("Jalebi", "Traditional", 30.0, 100));
        savedSweet2 = sweetRepository.save(new Sweets("Kaju Katli", "Premium", 50.0, 50));
    }

    // Clean up the database after each test to ensure isolation
    @AfterEach
    void tearDownDatabase() {
        sweetRepository.deleteAll();
    }

    @Test
    @DisplayName("Scenario: A new sweet is created successfully")
    void givenNewSweetDetails_whenCreateSweetIsCalled_thenSweetIsSavedAndReturned() {
        // Given: Details for a new sweet
        SweetsDto newSweetDto = new SweetsDto(null, "Laddu", "Traditional", 20.0, 200);

        // When: The createSweet method is called
        Optional<SweetsDto> result = sweetService.createSweet(newSweetDto);

        // Then: The sweet should be created successfully and returned as a DTO
        assertTrue(result.isPresent(), "A DTO should be returned");
        assertNotNull(result.get().getId(), "The created sweet should have an ID");
        assertEquals("Laddu", result.get().getName());

        // And: The sweet should exist in the database
        Sweets foundSweet = sweetRepository.findById(result.get().getId()).orElse(null);
        assertNotNull(foundSweet, "The sweet should be found in the repository");
        assertEquals("Laddu", foundSweet.getName());
    }

    @Test
    @DisplayName("Scenario: All sweets are retrieved from the database")
    void givenSweetsInDatabase_whenGetAllSweetsIsCalled_thenAllSweetsAreReturned() {
        // Given: Sweets already exist in the database (from @BeforeEach)

        // When: The getAllSweets method is called
        Optional<List<SweetsDto>> result = sweetService.getAllSweets();

        // Then: A list containing all the sweets should be returned
        assertTrue(result.isPresent(), "The list of sweets should be returned");
        assertEquals(2, result.get().size(), "There should be two sweets in the list");
    }

    @Test
    @DisplayName("Scenario: Requesting all sweets when none exist")
    void givenEmptyDatabase_whenGetAllSweetsIsCalled_thenAnEmptyOptionalIsReturned() {
        // Given: The database is empty
        sweetRepository.deleteAll();

        // When: The getAllSweets method is called
        Optional<List<SweetsDto>> result = sweetService.getAllSweets();

        // Then: The result should be an empty Optional
        assertTrue(result.isEmpty(), "The result should be empty");
    }

    @Test
    @DisplayName("Scenario: A sweet is found by its name")
    void givenAnExistingSweetName_whenGetSweetByNameIsCalled_thenTheCorrectSweetIsReturned() {
        // Given: The name of an existing sweet
        String sweetName = "Jalebi";

        // When: The getSweetByName method is called with that name
        Optional<SweetsDto> result = sweetService.getSweetByName(sweetName);

        // Then: The DTO for the correct sweet should be returned
        assertTrue(result.isPresent(), "A sweet should be found");
        assertEquals(savedSweet1.getId(), result.get().getId());
        assertEquals(sweetName, result.get().getName());
    }

    @Test
    @DisplayName("Scenario: Searching for a sweet with a name that does not exist")
    void givenANonExistentSweetName_whenGetSweetByNameIsCalled_thenAnEmptyOptionalIsReturned() {
        // Given: A name that does not correspond to any sweet in the database
        String nonExistentName = "Barfi";

        // When: The getSweetByName method is called
        Optional<SweetsDto> result = sweetService.getSweetByName(nonExistentName);

        // Then: The result should be an empty Optional
        assertTrue(result.isEmpty(), "No sweet should be found");
    }

    @Test
    @DisplayName("Scenario: A sweet is successfully updated")
    void givenAnExistingSweetIdAndNewDetails_whenUpdateSweetIsCalled_thenTheSweetIsUpdatedInDatabase() {
        // Given: The ID of an existing sweet and new details
        String existingId = savedSweet1.getId();
        SweetsDto updateDto = new SweetsDto(null, "Crispy Jalebi", "Traditional", 35.0, 90);

        // When: The updateSweet method is called
        Optional<SweetsDto> result = sweetService.updateSweet(existingId, updateDto);

        // Then: The updated sweet DTO should be returned
        assertTrue(result.isPresent(), "Updated DTO should be returned");
        assertEquals("Crispy Jalebi", result.get().getName());
        assertEquals(35.0, result.get().getPrice());

        // And: The changes should be reflected in the database
        Sweets updatedEntityInDb = sweetRepository.findById(existingId).get();
        assertEquals("Crispy Jalebi", updatedEntityInDb.getName());
    }

    @Test
    @DisplayName("Scenario: Attempting to update a sweet that does not exist")
    void givenANonExistentSweetId_whenUpdateSweetIsCalled_thenAnEmptyOptionalIsReturned() {
        // Given: A non-existent ID and some update details
        String nonExistentId = "non-existent-id";
        SweetsDto updateDto = new SweetsDto(null, "Fake Sweet", "Fake", 10.0, 10);

        // When: The updateSweet method is called
        Optional<SweetsDto> result = sweetService.updateSweet(nonExistentId, updateDto);

        // Then: The result should be an empty Optional
        assertTrue(result.isEmpty(), "No sweet should be updated");
    }


    @Test
    @DisplayName("Scenario: A sweet is successfully deleted")
    void givenAnExistingSweetId_whenDeleteSweetIsCalled_thenSweetIsRemovedFromDatabase() {
        // Given: The ID of an existing sweet
        String existingId = savedSweet1.getId();
        assertEquals(2, sweetRepository.count(), "Pre-condition: 2 sweets should be in the database");

        // When: The deleteSweetById method is called
        Optional<String> result = sweetService.deleteSweetById(existingId);

        // Then: A confirmation message should be returned
        assertTrue(result.isPresent(), "A success message should be returned");

        // And: The sweet should no longer exist in the database
        assertFalse(sweetRepository.findById(existingId).isPresent(), "Sweet should be deleted");
        assertEquals(1, sweetRepository.count(), "Post-condition: 1 sweet should remain in the database");
    }

    @Test
    @DisplayName("Scenario: Attempting to delete a sweet that does not exist")
    void givenANonExistentSweetId_whenDeleteSweetIsCalled_thenAnEmptyOptionalIsReturned() {
        // Given: A non-existent ID
        String nonExistentId = "non-existent-id";

        // When: The deleteSweetById method is called
        Optional<String> result = sweetService.deleteSweetById(nonExistentId);

        // Then: The result should be an empty Optional
        assertTrue(result.isEmpty(), "The result should be empty");

        // And: The number of sweets in the database should be unchanged
        assertEquals(2, sweetRepository.count(), "The number of sweets should not change");
    }
    @Test
    @DisplayName("Scenario (Fail): Attempting to create a sweet with a duplicate name")
    void givenDuplicateSweetName_whenCreateSweetIsCalled_thenItShouldFail() {
        // Given: Details for a new sweet with a name that already exists ("Jalebi")
        SweetsDto duplicateSweetDto = new SweetsDto(null, "Jalebi", "Traditional", 25.0, 150);

        // When & Then: Calling createSweet should throw a DataIntegrityViolationException
        // because the 'name' field has a unique constraint in the database.
        assertThrows(DataIntegrityViolationException.class, () -> {
            sweetService.createSweet(duplicateSweetDto);
        }, "Should throw DataIntegrityViolationException for duplicate name");
    }

    @Test
    @DisplayName("Scenario (Fail): Attempting to create a sweet with a null name")
    void givenSweetWithNullName_whenCreateSweetIsCalled_thenItShouldFail() {
        // Given: A DTO with a null name, which is invalid.
        SweetsDto invalidDto = new SweetsDto(null, null, "Category", 30.0, 100);

        // When & Then: The service layer should throw an exception.
        // This is because the database column for 'name' will not allow null values.
        assertThrows(DataIntegrityViolationException.class, () -> {
            sweetService.createSweet(invalidDto);
        }, "Should throw an exception for a null name");
    }

    @Test
    @DisplayName("Scenario (Fail): Attempting to retrieve sweets by a price that does not exist")
    void givenNonExistentPrice_whenGetSweetByPriceIsCalled_thenAnEmptyOptionalIsReturned() {
        // Given: A price that does not match any sweet in the database
        Double nonExistentPrice = 999.99;

        // When: The getSweetByPrice method is called
        Optional<List<SweetsDto>> result = sweetService.getSweetByPrice(nonExistentPrice);

        // Then: The result should be an empty Optional, as no sweets match this price.
        // This confirms the "not found" failure path works as expected.
        assertFalse(result.isEmpty(), "Result should be empty for a non-existent price");
    }
}
