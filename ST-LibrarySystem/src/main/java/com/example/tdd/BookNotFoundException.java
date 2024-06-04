package com.example.tdd;

public class BookNotFoundException extends  RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}
