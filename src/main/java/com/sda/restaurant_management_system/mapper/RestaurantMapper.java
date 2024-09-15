package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.model.Restaurant;

public class RestaurantMapper {
    public static Restaurant mapTo(RestaurantDTO restaurantDTO){
        Restaurant restaurant= new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurantDTO.setId(restaurantDTO.getId());
        restaurantDTO.setCity(restaurantDTO.getCity());
        restaurantDTO.setAddress(restaurantDTO.getAddress());
        restaurantDTO.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantDTO.setInstagramUsername(restaurantDTO.getInstagramUsername());
        return restaurant;
    }
    public static RestaurantDTO mapToDTO(Restaurant restaurant){
        RestaurantDTO restaurantDTO=new RestaurantDTO();
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setCity(restaurant.getCity());
        restaurantDTO.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantDTO.setInstagramUsername(restaurant.getInstagramUsername());
        return restaurantDTO;
    }
}
