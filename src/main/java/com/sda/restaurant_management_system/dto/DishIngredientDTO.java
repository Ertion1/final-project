package com.sda.restaurant_management_system.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DishIngredientDTO {
    private Integer id;
    private Integer quantity;
    private DishDTO dish;
    private IngredientDTO ingredient ;
}
