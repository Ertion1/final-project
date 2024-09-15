package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.DishDTO;
import com.sda.restaurant_management_system.model.Dish;

import java.util.List;

public interface DishService  {
    void save (DishDTO dishDTO);
    void uppdate (DishDTO dishDTO,Integer id);
    DishDTO findById(Integer id);
    List<DishDTO>findAll();
    void delete(Integer id);


}
