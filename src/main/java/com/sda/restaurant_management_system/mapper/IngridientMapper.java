package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.IngridientDTO;
import com.sda.restaurant_management_system.model.Ingredient;

public class IngridientMapper {
    public static Ingredient mapTEntity(IngridientDTO ingridientDTO) {
        Ingredient ingridient = new Ingredient();
        ingridient.setName(ingridientDTO.getName());
        return ingridient;
    }

    public static IngridientDTO mapToDTO(Ingredient ingredient) {
        IngridientDTO ingridientDTO = new IngridientDTO();
        ingridientDTO.setId(ingridientDTO.getId());
        ingridientDTO.setName(ingridientDTO.getName());
        ingridientDTO.setCalories(ingridientDTO.getCalories());
        ingridientDTO.setQuantityType(ingridientDTO.getQuantityType());
        return ingridientDTO;
    }
}
