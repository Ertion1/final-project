package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.DishIngredientDTO;

import java.util.List;

public interface DishIngredientService {
    void save(DishIngredientDTO dishIngridientDTO);

    void update(DishIngredientDTO dishIngridientDTO, Integer id);
    DishIngredientDTO findById(Integer id);
    List<DishIngredientDTO> findAll();
    void delete (Integer id);


}
