package com.sda.restaurant_management_system.api;

import com.sda.restaurant_management_system.dto.OrderDishDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.service.OrderDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping( "/order-dish")
public class OrderDishController
{
    @Autowired
    private OrderDishService orderDishService;
    @PostMapping
    public void save(@RequestBody OrderDishDTO orderDishDTO){
        this.orderDishService.save(orderDishDTO);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody OrderDishDTO orderDishDTO, @PathVariable("id") Integer Id){
        orderDishService.update(orderDishDTO , Id);
    }
    @GetMapping("/{id}")
    public OrderDishDTO findbyId(@PathVariable("id") Integer id){
        return orderDishService.findById(id);
    }
    @GetMapping
    public List<OrderDishDTO> findAll() {
        return orderDishService.findAll();
    }
    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Integer id) {
        orderDishService.delete(id);
    }
    @PostMapping ("/filter")
    public List<OrderDishDTO> filter (@RequestBody Filters filters){
        return orderDishService.filter(filters);
    }
}







