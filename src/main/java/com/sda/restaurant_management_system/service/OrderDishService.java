package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.OrderDishDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import java.util.List;
public interface OrderDishService {
    void save (OrderDishDTO orderDishDTO);
    void update(OrderDishDTO ingredientDTO, Integer id);
    OrderDishDTO findById(Integer id);
    List<OrderDishDTO> findAll();
    void delete(Integer id);
    List<OrderDishDTO> filter(Filters filters);
}