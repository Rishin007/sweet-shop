package com.example.controller;

import com.example.dto.SweetsDto;
import com.example.exception.ListOfSweetsNotFoundException;
import com.example.exception.SweetNotCreatedException;
import com.example.exception.SweetsNotFoundException;
import com.example.service.SweetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing sweets.
 * Exposes endpoints for creating, retrieving, updating, and deleting sweets.
 */
@AllArgsConstructor
@RestController
@RequestMapping("sweets")
public class SweetsController {
    private final SweetService sweetService;

    /**
     * Handles the HTTP POST request to create a new sweet.
     *
     * @param sweetsDto The sweet data sent in the request body. Validated by @Valid.
     * @return A ResponseEntity with the created sweet's DTO and HTTP status 201 (Created).
     * @throws SweetNotCreatedException if the sweet could not be created.
     */
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<SweetsDto> createSweets(@Valid @RequestBody SweetsDto sweetsDto){
        return new ResponseEntity<>(sweetService.createSweet(sweetsDto)
                .orElseThrow(()-> new SweetNotCreatedException("Sweet")),HttpStatus.CREATED);
    }

    /**
     * Handles the HTTP GET request to retrieve all sweets.
     *
     * @return A ResponseEntity with a list of all sweet DTOs and HTTP status 200 (OK).
     * @throws ListOfSweetsNotFoundException if no sweets are found.
     */
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<SweetsDto>> getAllSweets(){
        return new ResponseEntity<>(sweetService.getAllSweets()
                .orElseThrow(()->new ListOfSweetsNotFoundException("No List of Sweets Found"))
                ,HttpStatus.OK);
    }

    /**
     * Handles the HTTP GET request to find a sweet by its name.
     *
     * @param name The name of the sweet, passed as a path variable.
     * @return A ResponseEntity with the found sweet's DTO and HTTP status 200 (OK).
     * @throws SweetsNotFoundException if no sweet with the given name is found.
     */
    @GetMapping("name/{name}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<SweetsDto> getAllSweetByName(@PathVariable String name){
        return new ResponseEntity<>(sweetService.getSweetByName(name)
                .orElseThrow(()->new SweetsNotFoundException("Sweet")),HttpStatus.OK);
    }

    /**
     * Handles the HTTP GET request to find all sweets by a specific price.
     *
     * @param price The price to search for, passed as a path variable.
     * @return A ResponseEntity with a list of matching sweet DTOs and HTTP status 200 (OK).
     * @throws SweetsNotFoundException if no sweets are found at the given price.
     */
    @GetMapping("price/{price}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<SweetsDto>> getAllSweetsByPrice(@PathVariable Double price){
        return new ResponseEntity<>(sweetService.getSweetByPrice(price)
                .orElseThrow(()->new SweetsNotFoundException("Sweets")),HttpStatus.OK);
    }

    /**
     * Handles the HTTP GET request to find all sweets in a specific category.
     *
     * @param category The category to search for, passed as a path variable.
     * @return A ResponseEntity with a list of matching sweet DTOs and HTTP status 200 (OK).
     * @throws SweetsNotFoundException if no sweets are found in the given category.
     */
    @GetMapping("category/{category}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<SweetsDto>> getAllSweetsByCategory(@PathVariable String category){
        return new ResponseEntity<>(sweetService.getSweetByCategory(category)
                .orElseThrow(()->new SweetsNotFoundException("Sweets")),HttpStatus.OK);
    }

    /**
     * Handles the HTTP PUT request to update an existing sweet.
     *
     * @param id The ID of the sweet to update, passed as a path variable.
     * @param sweetsDto The updated sweet data sent in the request body. Validated by @Valid.
     * @return A ResponseEntity with the updated sweet's DTO and HTTP status 200 (OK).
     * @throws SweetsNotFoundException if no sweet with the given ID is found.
     */
    @PutMapping("{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<SweetsDto> updateSweets(@PathVariable String id, @Valid @RequestBody SweetsDto sweetsDto){
        return new ResponseEntity<>(sweetService.updateSweet(id,sweetsDto)
                .orElseThrow(()-> new SweetsNotFoundException("Sweet","id",id)), HttpStatus.OK);
    }

    /**
     * Handles the HTTP DELETE request to remove a sweet.
     *
     * @param id The ID of the sweet to delete, passed as a path variable.
     * @return A ResponseEntity with a confirmation message and HTTP status 200 (OK).
     * @throws SweetsNotFoundException if no sweet with the given ID is found.
     */
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteSweets(@PathVariable String id){
        return new ResponseEntity<>(sweetService.deleteSweetById(id)
                .orElseThrow(()-> new SweetsNotFoundException("Sweet","id",id)), HttpStatus.OK);
    }
}