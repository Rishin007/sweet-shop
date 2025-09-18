package com.example.exception;

public class ListOfSweetsNotFoundException extends RuntimeException {
    public  ListOfSweetsNotFoundException(String message){
        super(message);
    }
}
