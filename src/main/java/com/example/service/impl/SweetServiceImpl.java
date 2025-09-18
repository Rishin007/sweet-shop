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

@Service
@AllArgsConstructor
public class SweetServiceImpl implements SweetService {
    private SweetRepository sweetRepo;

    @Override
    public Optional<SweetsDto> createSweet(SweetsDto sweetsdto) {
        if(sweetRepo.save(Mapper.SweetsDtoToSweets(sweetsdto)) != null){
            Sweets sweets = Mapper.SweetsDtoToSweets(sweetsdto);
            return Optional.of(Mapper.SweetsToSweetsDto(sweets));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<SweetsDto>> getAllSweets() {
        List<Sweets> sweets = sweetRepo.findAll();
        List<SweetsDto> sweetsDto=new ArrayList<>();
       if(sweetRepo.findAll().size()>0){
           for(Sweets sd: sweets){
               sweetsDto.add(Mapper.SweetsToSweetsDto(sd));
           }
           return Optional.of(sweetsDto);
       }
        return Optional.empty();
    }

    @Override
    public Optional<SweetsDto> getSweetByName(String name) {
        if(sweetRepo.findSweetsByName(name) != null){
            return Optional.of(Mapper.SweetsToSweetsDto(sweetRepo.findSweetsByName(name)));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<SweetsDto>> getSweetByPrice(Double price) {
        if(sweetRepo.findSweetsByPrice(price) != null) {
            List<Sweets> sweetsList = sweetRepo.findSweetsByPrice(price);
            List<SweetsDto> sweetsDto = new ArrayList<>();
            for (Sweets s : sweetsList) {
                sweetsDto.add(Mapper.SweetsToSweetsDto(s));
            }
            return Optional.of(sweetsDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<SweetsDto>> getSweetByCategory(String category) {
        if(sweetRepo.findSweetsByCategory(category)!=null) {
            List<Sweets> sweetsList = sweetRepo.findSweetsByCategory(category);
            List<SweetsDto> sweetsDto = new ArrayList<>();
            for (Sweets s : sweetsList) {
                sweetsDto.add(Mapper.SweetsToSweetsDto(s));
            }
            return Optional.of(sweetsDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<SweetsDto> updateSweet(String id,SweetsDto sweetsDto) {
        if(sweetRepo.findById(id).isPresent()){
            Sweets s= sweetRepo.findById(id).get();
            s.setId(id);
            s.setName(sweetsDto.getName());
            s.setPrice(sweetsDto.getPrice());
            s.setCategory(sweetsDto.getCategory());
            s.setQuantity(sweetsDto.getQuantity());
            sweetRepo.save(s);
            return Optional.of(Mapper.SweetsToSweetsDto(s));
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> deleteSweetById(String id) {
        if (sweetRepo.findById(id).isPresent()) {
            sweetRepo.deleteById(id);
            return Optional.of("Sweet with id " + id + " has been deleted");
        }
        return Optional.empty();
    }
}
