package com.sda.restaurant_management_system.service;
import com.sda.restaurant_management_system.dto.IngredientDTO;

import java.util.List;

public interface IngredientService {
    void save (IngredientDTO ingridientDTO);
    void update(IngredientDTO ingredientDTO, Integer id);
    IngredientDTO findById(Integer id);
    List<IngredientDTO> findAll();
    void delete(Integer id);

}