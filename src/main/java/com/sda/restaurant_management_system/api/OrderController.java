package com.sda.restaurant_management_system.api;

import com.sda.restaurant_management_system.dto.ClientDTO;
import com.sda.restaurant_management_system.dto.OrderDTO;
import com.sda.restaurant_management_system.dto.OrderDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping
    public void save(@RequestBody OrderDTO orderDTO){
        this.orderService.save(orderDTO);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody OrderDTO OrderDTO, @PathVariable("id") Integer Id){
        orderService.update(OrderDTO , Id);
    }
    @GetMapping("/{id}")
    public OrderDTO findbyId(@PathVariable("id") Integer id){
        return orderService.findbyId(id);
    }

    @GetMapping
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Integer id) {
        orderService.delete(id);
    }

    @PostMapping ("/filter")
    public List<OrderDTO> filter(@RequestBody Filters filters){
        return orderService.filter(filters);
    }
}
