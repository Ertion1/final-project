package com.sda.restaurant_management_system.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {

        super(message);
    }
}
