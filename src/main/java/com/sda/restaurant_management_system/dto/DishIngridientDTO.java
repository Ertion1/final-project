package com.sda.restaurant_management_system.dto;

import com.sda.restaurant_management_system.model.Dish;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DishIngridientDTO {
    private Integer id;
    private Integer quantity;
    private DishDTO dish;
    private IngridientDTO ingredient;
}
