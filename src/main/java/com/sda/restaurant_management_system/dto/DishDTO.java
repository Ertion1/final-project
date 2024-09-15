package com.sda.restaurant_management_system.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class DishDTO {
    private Integer id;
    private String name;
    private Integer price;
    private Integer totalDishCalories;
    private RestaurantDTO restaurant;
}
