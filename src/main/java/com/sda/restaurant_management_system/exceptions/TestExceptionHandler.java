package com.sda.restaurant_management_system.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorFormat handleNotFound(NotFoundException exception){
        ErrorFormat errorFormat = new ErrorFormat();
        errorFormat.setMessage(exception.getMessage());
        errorFormat.setTime(LocalDateTime.now());
        return errorFormat;

    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorFormat handleBadRequest(BadRequestException exception)
    {
        ErrorFormat errorFormat=new ErrorFormat();
        errorFormat.setMessage(exception.getMessage());
        errorFormat.setTime(LocalDateTime.now());
        return errorFormat;
    }


}
