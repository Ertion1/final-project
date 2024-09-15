package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
}
