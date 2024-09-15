package com.sda.restaurant_management_system.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO { // POJO - Plaing Old Java Objects

    private Integer id;
    private  Integer totalPrice ;
    private RestaurantDTO restaurant;
    private ClientDTO client;


}
