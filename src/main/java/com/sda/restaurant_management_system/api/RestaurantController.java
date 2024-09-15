package com.sda.restaurant_management_system.api;

import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

   @Autowired
    private RestaurantService restaurantService;
   @PostMapping
    public void save(@RequestBody RestaurantDTO restaurantDTO){
        this.restaurantService.save(restaurantDTO);
     }
}
