package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.OrderDTO;
import com.sda.restaurant_management_system.model.Order;

public class OrderMapper {
    public static Order mapToEntity (OrderDTO orderDTO) {
        Order order = new Order();
        order.setTotalPrice(orderDTO.getTotalPrice());
        return order;
    }

    public static OrderDTO mapToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setTotalPrice(orderDTO.getTotalPrice());
        orderDTO.setId(order.getId());
        return orderDTO;
    }
}
