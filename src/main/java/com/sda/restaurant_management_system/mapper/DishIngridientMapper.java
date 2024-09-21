package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.DishIngridientDTO;
import com.sda.restaurant_management_system.model.Dish;
import com.sda.restaurant_management_system.model.DishIngredient;
import com.sda.restaurant_management_system.model.Ingredient;

public class DishIngridientMapper {
  public static DishIngredient mapToEntity( Dish dish, Ingredient ingredient)
  {
   DishIngredient dishIngredient = new DishIngredient();
   dishIngredient.setDish(dish);
   dishIngredient.setIngredient(ingredient);
   return dishIngredient;
  }

  public static DishIngridientDTO mapToDTO(DishIngredient dishIngredient)
  {
      DishIngridientDTO dishIngridientDTO = new DishIngridientDTO();
      dishIngridientDTO.setId(dishIngredient.getId());
      dishIngridientDTO.setDish(DishMapper.mapToDTO(dishIngredient.getDish()));
      dishIngridientDTO.setIngredient(IngridientMapper.mapToDTO(dishIngredient.getIngredient()));
      dishIngridientDTO.setQuantity(dishIngredient.getQuantity());
      return dishIngridientDTO;
  }

}
