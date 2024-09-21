package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.DishIngredientDTO;
import com.sda.restaurant_management_system.model.Dish;
import com.sda.restaurant_management_system.model.DishIngredient;
import com.sda.restaurant_management_system.model.Ingredient;

public class DishIngredientMapper {
  public static DishIngredient mapToEntity( Dish dish, Ingredient ingredient)
  {
   DishIngredient dishIngredient = new DishIngredient();
   dishIngredient.setDish(dish);
   dishIngredient.setIngredient(ingredient);
   return dishIngredient;
  }

  public static DishIngredientDTO mapToDTO(DishIngredient dishIngredient)
  {
      DishIngredientDTO dishIngridientDTO = new DishIngredientDTO();
      dishIngridientDTO.setId(dishIngredient.getId());
      dishIngridientDTO.setDish(DishMapper.mapToDTO(dishIngredient.getDish()));
      dishIngridientDTO.setIngredient(IngredientMapper.mapToDTO(dishIngredient.getIngredient()));
      dishIngridientDTO.setQuantity(dishIngredient.getQuantity());
      return dishIngridientDTO;
  }

}
