package com.sda.restaurant_management_system.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class IngridientDTO {
    private Integer id;
    private String name;
    private Integer calories;
    private String quantityType;
}
