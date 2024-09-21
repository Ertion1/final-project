package com.sda.restaurant_management_system.api;

import com.sda.restaurant_management_system.dto.ClientDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
   @PostMapping
    public void save(@RequestBody RestaurantDTO restaurantDTO){
        this.restaurantService.save(restaurantDTO);
     }
    @PutMapping ("/{id}")
    public void update(@RequestBody RestaurantDTO restaurantDTO, @PathVariable("id") Integer Id){
        restaurantService.update(restaurantDTO , Id);
    }
    @GetMapping("/{id}")
    public RestaurantDTO findbyId(@PathVariable("id") Integer id){
        return restaurantService.findById(id);
    }

    @GetMapping
    public List<RestaurantDTO> findAll() {
        return restaurantService.findAll();
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Integer id) {
        restaurantService.delete(id);
    }
    @PostMapping ("/filter")
    public List<RestaurantDTO> filter (@RequestBody Filters filters){
        return restaurantService.filter(filters);
    }

}
