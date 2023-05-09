package com.restojavadev11.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EntityNotFoundException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(EntityNotFoundException.class.getName());
    public EntityNotFoundException(String message) {
        super(message);
        logger.log(Level.SEVERE, message);
    }
}
