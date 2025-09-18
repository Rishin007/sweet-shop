package com.example.converter;

import com.example.dto.SweetsDto;
import com.example.entity.Sweets;

/**
 * A utility class to map between Sweets entity and its DTO representation.
 */
public class Mapper {

    /**
     * Converts a Sweets entity object to a SweetsDto.
     * @param sweets The entity to convert.
     * @return The resulting DTO.
     */
    public static SweetsDto SweetsToSweetsDto(Sweets sweets){
        return new SweetsDto(
                sweets.getId(), sweets.getName(), sweets.getCategory(), sweets.getPrice(), sweets.getQuantity()
        );
    }

    /**
     * Converts a SweetsDto to a Sweets entity object.
     * @param sweetsDto The DTO to convert.
     * @return The resulting entity.
     */
    public static Sweets SweetsDtoToSweets(SweetsDto sweetsDto){
        Sweets sweets = new Sweets();
        sweets.setId(sweetsDto.getId());
        sweets.setName(sweetsDto.getName());
        sweets.setCategory(sweetsDto.getCategory());
        sweets.setPrice(sweetsDto.getPrice());
        sweets.setQuantity(sweetsDto.getQuantity());
        return sweets;
    }
}