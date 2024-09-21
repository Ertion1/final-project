package com.sda.restaurant_management_system.api;

import com.sda.restaurant_management_system.dto.DishDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ( "/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    public void save(@RequestBody DishDTO dishDTO){
        this.dishService.save(dishDTO);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody DishDTO dishDTO, @PathVariable("id") Integer Id){
        dishService.update(dishDTO , Id);
    }
    @GetMapping("/{id}")
    public DishDTO findbyId(@PathVariable("id") Integer id){
        return dishService.findById(id);
    }

    @GetMapping
    public List<DishDTO> findAll() {
        return dishService.findAll();
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Integer id) {
        dishService.delete(id);
    }
    @PostMapping ("/filter")
    public List<DishDTO> filter (@RequestBody Filters filters){
        return dishService.filter(filters);
    }
}
