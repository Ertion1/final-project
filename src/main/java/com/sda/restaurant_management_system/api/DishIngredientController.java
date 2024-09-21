package com.sda.restaurant_management_system.api;

import com.sda.restaurant_management_system.dto.DishIngredientDTO;
import com.sda.restaurant_management_system.dto.IngredientDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.model.DishIngredient;
import com.sda.restaurant_management_system.service.DishIngredientService;
import com.sda.restaurant_management_system.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/dish-ingredient")
public class DishIngredientController
{
    @Autowired
    private DishIngredientService dishIngredientService;
    @PostMapping
    public void save(@RequestBody DishIngredientDTO dishIngredientDTO){
        this.dishIngredientService.save(dishIngredientDTO);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody DishIngredientDTO dishIngredientDTO, @PathVariable("id") Integer Id){
        dishIngredientService.update(dishIngredientDTO , Id);
    }
    @GetMapping("/{id}")
    public DishIngredientDTO findbyId(@PathVariable("id") Integer id){
        return dishIngredientService.findById(id);
    }

    @GetMapping
    public List<DishIngredientDTO> findAll() {
        return dishIngredientService.findAll();
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Integer id) {
        dishIngredientService.delete(id);
    }
    @PostMapping ("/filter")
    public List<DishIngredientDTO> filter (@RequestBody Filters filters){
        return dishIngredientService.filter(filters);
    }
}
