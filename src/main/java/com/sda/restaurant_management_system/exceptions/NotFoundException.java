package com.sda.restaurant_management_system.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {

        super(message);
    }
}
