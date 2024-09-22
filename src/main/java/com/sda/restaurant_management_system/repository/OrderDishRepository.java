package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.OrderDish;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDishRepository extends JpaRepository<OrderDish, Integer> {

   List<OrderDish> findAllByDishId(Integer id);
}
