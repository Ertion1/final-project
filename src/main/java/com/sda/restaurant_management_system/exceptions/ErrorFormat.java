package com.sda.restaurant_management_system.exceptions;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ErrorFormat {
    private String message;
    private LocalDateTime time;


}
