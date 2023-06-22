package com.levi.enterprises.spring.springProject.services.exceptions;

public class DatabaseException extends RuntimeException{
    
    public DatabaseException(String msg){
        super(msg);
    }
}
