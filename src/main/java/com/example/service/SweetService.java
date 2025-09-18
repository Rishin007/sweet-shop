package com.example.service;

import com.example.dto.SweetsDto;


import java.util.List;
import java.util.Optional;

public interface SweetService {
    Optional<SweetsDto> createSweet(SweetsDto sweetsDto);
    Optional<List<SweetsDto>> getAllSweets();
    Optional<SweetsDto> getSweetByName(String name);
    Optional<List<SweetsDto>> getSweetByPrice(Double price);
    Optional<List<SweetsDto>> getSweetByCategory(String category);
    Optional<SweetsDto> updateSweet(String id,SweetsDto sweetsDto);
    Optional<String> deleteSweetById(String id);
}
