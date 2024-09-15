package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    void save(RestaurantDTO restaurantDTO);
    void update(RestaurantDTO restaurantDTO,Integer id);
    RestaurantDTO findById(Integer Id);

    List<RestaurantDTO>findAll();
    void delete(Integer Id);

}
