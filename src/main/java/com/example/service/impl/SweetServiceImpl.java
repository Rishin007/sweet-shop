package com.example.service.impl;

import com.example.converter.Mapper;
import com.example.dto.SweetsDto;
import com.example.entity.Sweets;
import com.example.repository.SweetRepository;
import com.example.service.SweetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The implementation of the SweetService interface, handling all business logic for sweets.
 */
@Service
@AllArgsConstructor
public class SweetServiceImpl implements SweetService {
    private SweetRepository sweetRepo;

    /**
     * Creates and saves a new sweet entity from a DTO.
     */
    @Override
    public Optional<SweetsDto> createSweet(SweetsDto sweetsdto) {
        Sweets sweets = sweetRepo.save(Mapper.SweetsDtoToSweets(sweetsdto));
        return Optional.of(Mapper.SweetsToSweetsDto(sweets));
    }

    /**
     * Retrieves all sweets from the database and converts them to DTOs.
     */
    @Override
    public Optional<List<SweetsDto>> getAllSweets() {
        List<Sweets> sweets = sweetRepo.findAll();
        if(!sweets.isEmpty()){
            List<SweetsDto> sweetsDto = sweets.stream()
                    .map(Mapper::SweetsToSweetsDto)
                    .collect(Collectors.toList());
            return Optional.of(sweetsDto);
        }
        return Optional.empty();
    }

    /**
     * Finds a single sweet by its name.
     */
    @Override
    public Optional<SweetsDto> getSweetByName(String name) {
        Sweets sweet = sweetRepo.findSweetsByName(name);
        return (sweet != null) ? Optional.of(Mapper.SweetsToSweetsDto(sweet)) : Optional.empty();
    }

    /**
     * Finds all sweets that match a given price.
     */
    @Override
    public Optional<List<SweetsDto>> getSweetByPrice(Double price) {
        List<Sweets> sweetsList = sweetRepo.findSweetsByPrice(price);
        if(sweetsList != null && !sweetsList.isEmpty()) {
            List<SweetsDto> sweetsDto = sweetsList.stream()
                    .map(Mapper::SweetsToSweetsDto)
                    .collect(Collectors.toList());
            return Optional.of(sweetsDto);
        }
        return Optional.empty();
    }

    /**
     * Finds all sweets that belong to a given category.
     */
    @Override
    public Optional<List<SweetsDto>> getSweetByCategory(String category) {
        List<Sweets> sweetsList = sweetRepo.findSweetsByCategory(category);
        if(sweetsList != null && !sweetsList.isEmpty()) {
            List<SweetsDto> sweetsDto = sweetsList.stream()
                    .map(Mapper::SweetsToSweetsDto)
                    .collect(Collectors.toList());
            return Optional.of(sweetsDto);
        }
        return Optional.empty();
    }

    /**
     * Updates an existing sweet's data using its ID.
     */
    @Override
    public Optional<SweetsDto> updateSweet(String id,SweetsDto sweetsDto) {
        return sweetRepo.findById(id).map(s -> {
            s.setName(sweetsDto.getName());
            s.setPrice(sweetsDto.getPrice());
            s.setCategory(sweetsDto.getCategory());
            s.setQuantity(sweetsDto.getQuantity());
            Sweets updatedSweet = sweetRepo.save(s);
            return Mapper.SweetsToSweetsDto(updatedSweet);
        });
    }

    /**
     * Deletes a sweet from the database based on its ID.
     */
    @Override
    public Optional<String> deleteSweetById(String id) {
        if (sweetRepo.existsById(id)) {
            sweetRepo.deleteById(id);
            return Optional.of("Sweet with id " + id + " has been deleted");
        }
        return Optional.empty();
    }
}