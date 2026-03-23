package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
