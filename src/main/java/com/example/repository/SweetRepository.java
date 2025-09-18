package com.example.repository;

import com.example.dto.SweetsDto;
import com.example.entity.Sweets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SweetRepository extends JpaRepository<Sweets, String> {

    Sweets findSweetsByName(String name);

    @Query("select s from Sweets s where s.price=?1")
    List<Sweets> findSweetsByPrice(Double price);

    @Query("select c from Sweets c where c.category=?1")
    List<Sweets> findSweetsByCategory(String category);

}
