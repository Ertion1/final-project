package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.DishIngridientDTO;

import java.util.List;

public interface DishIngredientService {
    void save(DishIngridientDTO dishIngridientDTO);

    void update(DishIngridientDTO dishIngridientDTO,Integer id);
    DishIngridientDTO findById(Integer id);
    List<DishIngridientDTO> findAll();
    void delete (Integer id);
}
