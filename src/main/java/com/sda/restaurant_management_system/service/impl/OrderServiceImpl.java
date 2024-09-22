package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.OrderDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.mapper.DishMapper;
import com.sda.restaurant_management_system.mapper.OrderMapper;
import com.sda.restaurant_management_system.mapper.RestaurantMapper;
import com.sda.restaurant_management_system.model.Dish;
import com.sda.restaurant_management_system.model.Order;
import com.sda.restaurant_management_system.repository.OrderFilteringRepository;
import com.sda.restaurant_management_system.repository.OrderRepository;
import com.sda.restaurant_management_system.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderFilteringRepository orderFilteringRepository;
    @Override
    public void save(OrderDTO orderDTO) {
        Order order = OrderMapper.mapToEntity(orderDTO);
        this.orderRepository.save(order);
    }

    @Override
    public void update(OrderDTO orderDTO, Integer id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (!orderOptional.isPresent()) {
            throw new RuntimeException("Order with this id not fund");
        }
    }


    @Override
    public OrderDTO findbyId(Integer id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isPresent()){
            return OrderMapper.mapToDTO(orderOptional.get());

        }
        else{
            throw new RuntimeException("Order with this ID"+ id +"does not exist");

        }
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream().map(OrderMapper::mapToDTO).toList();
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

        @Override
        public List<OrderDTO> filter(Filters filters) {
            return orderFilteringRepository.filter(filters).stream().
                    map(OrderMapper::mapToDTO).toList();
        }

    @Override
    public List<OrderDTO> findAllSortedByPrice() {
        return orderRepository.findAllSortedByPrice().stream().map(OrderMapper::mapToDTO).toList();
    }
}
