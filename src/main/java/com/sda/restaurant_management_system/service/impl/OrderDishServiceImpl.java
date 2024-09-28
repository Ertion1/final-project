package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.DishIngredientDTO;
import com.sda.restaurant_management_system.dto.OrderDishDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.exceptions.BadRequestException;
import com.sda.restaurant_management_system.mapper.DishIngredientMapper;
import com.sda.restaurant_management_system.mapper.OrderDishMapper;
import com.sda.restaurant_management_system.model.*;
import com.sda.restaurant_management_system.repository.*;
import com.sda.restaurant_management_system.service.OrderDishService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
@Transactional @RequiredArgsConstructor
public class OrderDishServiceImpl implements OrderDishService {
    private final OrderDishRepository orderDishRepository;
    private final OrderDishFilteringRepository orderDishFilteringRepository ;
    private  final DishRepository dishRepository;
    private final OrderRepository orderRepository;
    @Override
    public void save(OrderDishDTO orderDishDTO) {
        Integer dishID = orderDishDTO.getDish().getId();
        Integer ingredientID= orderDishDTO.getOrder().getId();

        Optional<Dish> dishOptional = dishRepository.findById(dishID);
        Optional<Order> orderOptional = orderRepository.findById(ingredientID);

        if(dishOptional.isPresent() && orderOptional.isPresent())
        {
            OrderDish orderDish = OrderDishMapper.mapToEntity(orderOptional.get(),dishOptional.get());
            this.orderDishRepository.save(orderDish);

            Order o = orderOptional.get();
            o.setTotalPrice(o.getTotalPrice() + dishOptional.get().getPrice());
            this.orderRepository.save(o);
        }else
        {
            throw new BadRequestException("Dish or order doesn't exist");
        }


    }

    @Override
    public void update(OrderDishDTO orderDishDTO,  Integer id) {
        // eshte me e thjeshte ta fshish dhe me pas ta krijosh nje rekord sesa ti besh update

        throw new RuntimeException("Not implemented");
    }

    @Override
    public OrderDishDTO findById(Integer id) {
        Optional<OrderDish> orderDish = orderDishRepository.findById(id);
        if(orderDish.isPresent())
        {
            return OrderDishMapper.maoToDTO(orderDish.get());
        }
        else
        {
            throw new RuntimeException("DishIngredient record not present");
        }

    }

    @Override
    public List<OrderDishDTO> findAll() {
        return orderDishRepository.findAll().stream().map(OrderDishMapper::maoToDTO).toList();
    }

    @Override
    public void delete(Integer id) {
        this.orderDishRepository.deleteById(id);
    }
    @Override
    public List<OrderDishDTO> filter(Filters filters) {
        return orderDishFilteringRepository.filter(filters).stream().
                map(OrderDishMapper::maoToDTO).toList();
    }
}


