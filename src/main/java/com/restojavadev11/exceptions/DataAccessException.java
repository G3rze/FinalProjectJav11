package com.restojavadev11.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessException extends RuntimeException{
    private static final Logger logger = Logger.getLogger(DataAccessException.class.getName());
    public DataAccessException(String message, Throwable cause){
        super(message, cause);
        logger.log(Level.SEVERE, message, cause);
    }
    
}
