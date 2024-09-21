package com.sda.restaurant_management_system.api;
import com.sda.restaurant_management_system.dto.DishDTO;
import com.sda.restaurant_management_system.dto.IngredientDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.model.Ingredient;
import com.sda.restaurant_management_system.service.DishService;
import com.sda.restaurant_management_system.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ( "/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @PostMapping
    public void save(@RequestBody IngredientDTO ingredientDTO){
        this.ingredientService.save(ingredientDTO);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody IngredientDTO ingredientDTO, @PathVariable("id") Integer Id){
        ingredientService.update(ingredientDTO , Id);
    }
    @GetMapping("/{id}")
    public IngredientDTO findbyId(@PathVariable("id") Integer id){
        return ingredientService.findById(id);
    }

    @GetMapping
    public List<IngredientDTO> findAll() {
        return ingredientService.findAll();
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Integer id) {
        ingredientService.delete(id);
    }
    @PostMapping ("/filter")
    public List<IngredientDTO> filter (@RequestBody Filters filters){
        return ingredientService.filter(filters);
    }

}
