package com.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class SweetsDto {

    private String id;
    @NotNull(message = "Enter a valid Sweet Name")
    private String name;
   @NotNull(message = "Please provide a valid category of sweets")
    private String category;
    @Min(value = 20,message = "Minimum price of the sweets should be 20 INR")
    private Double price;
   @Min(value = 1,message = "Minimum quantity to be entered is 1")
    private Integer quantity;


}
