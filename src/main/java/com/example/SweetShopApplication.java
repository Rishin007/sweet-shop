package com.example;

import com.example.repository.SweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@AllArgsConstructor
@SpringBootApplication
public class SweetShopApplication  {
private SweetRepository sweetRepo;
    public static void main(String[] args) {
        SpringApplication.run(SweetShopApplication.class, args);
    }

}
