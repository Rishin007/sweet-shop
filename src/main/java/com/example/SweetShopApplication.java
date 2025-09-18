package com.example;

import com.example.entity.Sweets;
import com.example.repository.SweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@AllArgsConstructor
@SpringBootApplication
public class SweetShopApplication implements CommandLineRunner {
private SweetRepository sweetRepo;
    public static void main(String[] args) {
        SpringApplication.run(SweetShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        sweetRepo.saveAll(
                List.of(
                        new Sweets("Rasogolla","Misti",58.66,8),
                        new Sweets("Misti Doi","Curd",98.66,28),
                        new Sweets("Raaj Bhog","Misti",168.44,77),
                        new Sweets("Kaaju Katli","Dry Sweets",58.66,45),
                        new Sweets("Soan Papdi","Dry Sweets",58.66,77),
                        new Sweets("Gulab Jamun","Misti",180.24,58),
                        new Sweets("Baarfi","Dry Sweets",24.79,37)

                )
        );
        System.out.println("Sweets saved successfully");
    }
}
