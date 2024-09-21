package com.sda.restaurant_management_system.service;
import com.sda.restaurant_management_system.dto.IngridientDTO;
import com.sda.restaurant_management_system.model.Ingredient;

import java.util.List;

public interface IngredientService {
    void save (IngridientDTO ingridientDTO);
    void update(IngridientDTO ingredientDTO,Integer id);
    IngridientDTO findById(Integer id);
    List<IngridientDTO> findAll();
    void delete(Integer id);

}