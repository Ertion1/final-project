package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.IngredientDTO;
import com.sda.restaurant_management_system.model.Ingredient;

public class IngredientMapper {
    public static Ingredient mapToEntity(IngredientDTO ingridientDTO) {
        Ingredient ingridient = new Ingredient();
        ingridient.setName(ingridientDTO.getName());
        return ingridient;
    }

    public static IngredientDTO mapToDTO(Ingredient ingredient) {
        IngredientDTO ingridientDTO = new IngredientDTO();
        ingridientDTO.setId(ingredient.getId());
        ingridientDTO.setName(ingredient.getName());
        ingridientDTO.setCalories(ingredient.getCalories());
        ingridientDTO.setQuantityType(ingredient.getQuantityType());
        return ingridientDTO;
    }
}
