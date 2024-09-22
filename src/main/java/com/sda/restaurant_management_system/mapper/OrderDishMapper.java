package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.OrderDishDTO;
import com.sda.restaurant_management_system.model.Dish;
import com.sda.restaurant_management_system.model.Order;
import com.sda.restaurant_management_system.model.OrderDish;

public class OrderDishMapper {
    public static OrderDish mapToEntity(Order order, Dish dish)
    {
        OrderDish orderDish = new OrderDish();
        orderDish.setDish(dish);
        orderDish.setOrder(order);
        return orderDish;
    }
    public static OrderDishDTO maoToDTO(OrderDish orderDish)
    {
        OrderDishDTO orderDishDTO = new OrderDishDTO();
        orderDishDTO.setId(orderDish.getId());
        orderDishDTO.setOrder(OrderMapper.mapToDTO(orderDish.getOrder()));
        orderDishDTO.setDish(DishMapper.mapToDTO(orderDish.getDish()));
        return orderDishDTO;
    }
}
