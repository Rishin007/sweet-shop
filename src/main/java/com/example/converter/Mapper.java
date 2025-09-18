package com.example.converter;

import com.example.dto.SweetsDto;
import com.example.entity.Sweets;

public class Mapper {
    public static SweetsDto SweetsToSweetsDto(Sweets sweets){
        SweetsDto sweetsDto = new SweetsDto(
                sweets.getId(), sweets.getName(), sweets.getCategory(), sweets.getPrice(), sweets.getQuantity()
        );
        return sweetsDto;
    }
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
