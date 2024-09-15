package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish,Integer> {

}
