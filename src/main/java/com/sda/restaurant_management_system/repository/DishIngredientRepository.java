package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.DishIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishIngredientRepository extends JpaRepository<DishIngredient,Integer> {

    List<DishIngredient> findAllByDishId(Integer id);
}
