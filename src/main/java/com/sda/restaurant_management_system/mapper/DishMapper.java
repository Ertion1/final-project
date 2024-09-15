package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.DishDTO;
import com.sda.restaurant_management_system.model.Dish;

import java.security.PublicKey;

public class DishMapper {
    public static Dish mapToEntity(DishDTO dishDTO){
        Dish dish=new Dish();
        dish.setName(dishDTO.getName());
        return dish;
    }
    public static DishDTO mapToDTO(Dish dishEntity){
        DishDTO dishDTO = new DishDTO();
        dishDTO.setId(dishEntity.getId());
        dishDTO.setName(dishEntity.getName());
        dishDTO.setPrice(dishEntity.getPrice());
        dishDTO.setTotalDishCalories(dishEntity.getTotalDishCalories());
        dishDTO.setRestaurant(RestaurantMapper.mapToDTO(dishEntity.getRestaurant()));
        return dishDTO;
    }
}
