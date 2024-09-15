package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {
}
