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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("sweets")
public class SweetsController {
    private final SweetService sweetService;

    @PostMapping
    public ResponseEntity<SweetsDto> createSweets(@Valid @RequestBody SweetsDto sweetsDto){
        return new ResponseEntity<>(sweetService.createSweet(sweetsDto)
                .orElseThrow(()-> new SweetNotCreatedException("Sweet")),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SweetsDto>> getAllSweets(){
        return new ResponseEntity<>(sweetService.getAllSweets()
                .orElseThrow(()->new ListOfSweetsNotFoundException("No List of Sweets Found"))
                ,HttpStatus.OK);
    }
    @GetMapping("name/{name}")
    public ResponseEntity<SweetsDto> getAllSweetByName(@PathVariable String name){
        return new ResponseEntity<>(sweetService.getSweetByName(name)
                .orElseThrow(()->new SweetsNotFoundException("Sweet")),HttpStatus.OK);
    }

    @GetMapping("price/{price}")
    public ResponseEntity<List<SweetsDto>> getAllSweetsByPrice(@PathVariable Double price){
        return new ResponseEntity<>(sweetService.getSweetByPrice(price)
                .orElseThrow(()->new SweetsNotFoundException("Sweets")),HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<SweetsDto>> getAllSweetsByCategory(@PathVariable String category){
        return new ResponseEntity<>(sweetService.getSweetByCategory(category)
                .orElseThrow(()->new SweetsNotFoundException("Sweets")),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<SweetsDto> updateSweets(@PathVariable String id, @Valid @RequestBody SweetsDto sweetsDto){
        return new ResponseEntity<>(sweetService.updateSweet(id,sweetsDto)
                .orElseThrow(()-> new SweetsNotFoundException("Sweet","id",id)), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSweets(@PathVariable String id){
        return new ResponseEntity<>(sweetService.deleteSweetById(id)
                .orElseThrow(()-> new SweetsNotFoundException("Sweet","id",id)), HttpStatus.OK);
    }
}
