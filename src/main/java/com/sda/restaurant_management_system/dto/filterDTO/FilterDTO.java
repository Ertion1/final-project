package com.sda.restaurant_management_system.dto.filterDTO;

import lombok.Data;

@Data
public class FilterDTO {
    private String field;
    private String value;
    private Operator operator;
    boolean test;

}
