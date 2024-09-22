package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.DishIngredientDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.model.Ingredient;

import java.util.List;

public interface DishIngredientService {
    void save(DishIngredientDTO dishIngridientDTO);

    void update(DishIngredientDTO dishIngridientDTO, Integer id);
    DishIngredientDTO findById(Integer id);
    List<DishIngredientDTO> findAll();
    void delete (Integer id);

    List<DishIngredientDTO> filter(Filters filters);

    List<Ingredient> findMostUsedIngredients();


}
