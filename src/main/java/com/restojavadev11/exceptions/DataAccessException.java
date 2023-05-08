package com.restojavadev11.exceptions;

public class DataAccessException extends RuntimeException{

    public DataAccessException(String message, Throwable cause){
        super(message, cause);
    }
    
}
