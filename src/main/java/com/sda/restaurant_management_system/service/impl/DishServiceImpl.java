package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.DishDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.mapper.DishMapper;
import com.sda.restaurant_management_system.mapper.RestaurantMapper;
import com.sda.restaurant_management_system.model.Dish;
import com.sda.restaurant_management_system.model.Restaurant;
import com.sda.restaurant_management_system.repository.DishFilteringRepository;
import com.sda.restaurant_management_system.repository.DishRepository;
import com.sda.restaurant_management_system.service.DishService;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishFilteringRepository dishFilteringRepository;

    @Override
    public void save(DishDTO dishDTO) {
        Dish dish = DishMapper.mapToEntity(dishDTO);
        this.dishRepository.save(dish);
    }

    @Override
    public void update(DishDTO dishDTO, Integer id) {
        Optional<Dish> dishOptional=dishRepository.findById(id);
        if (!dishOptional.isPresent()){
            throw new RuntimeException("Dish with this id not fund");

        }
        Dish dish = dishOptional.get();
        dish.setName(dishDTO.getName());
        this.dishRepository.save(dish);
    }

    @Override
    public DishDTO findById(Integer id) {
        Optional<Dish> dishOptional=dishRepository.findById(id);
        if(dishOptional.isPresent()){
            return DishMapper.mapToDTO(dishOptional.get());

        }
        else{
            throw new RuntimeException("Dish with this ID"+ id +"does not exist");

        }

    }

    @Override
    public List<DishDTO> findAll() {
        List<Dish> dish=this.dishRepository.findAll();
        List<DishDTO> dishDTOList=new ArrayList<>();
        for (Dish d:dish){
            DishDTO dishDTO=DishMapper.mapToDTO(d);
            dishDTOList.add(dishDTO);
        }
        return dishDTOList;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<DishDTO> filter(Filters filters) {
        return dishFilteringRepository.filter(filters).stream().
                map(DishMapper::mapToDTO).toList();
    }
}
