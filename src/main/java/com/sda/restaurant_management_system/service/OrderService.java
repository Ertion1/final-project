package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.OrderDTO;
import com.sda.restaurant_management_system.dto.OrderDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;

import java.util.List;

public interface OrderService {
    void save (OrderDTO clientDTO);
    void update (OrderDTO clientDTO , Integer Id);
    OrderDTO findbyId(Integer d);
    List<OrderDTO> findAll();
    void delete(Integer id);
    List<OrderDTO> filter(Filters filters);
}

