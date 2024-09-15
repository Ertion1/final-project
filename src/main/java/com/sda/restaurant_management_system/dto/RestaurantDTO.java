package com.sda.restaurant_management_system.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDTO {

    private Integer id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private String instagramUsername;
}

