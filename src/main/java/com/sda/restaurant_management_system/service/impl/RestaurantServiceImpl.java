package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.mapper.RestaurantMapper;
import com.sda.restaurant_management_system.model.Restaurant;
import com.sda.restaurant_management_system.repository.RestaurantRepository;
import com.sda.restaurant_management_system.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sda.restaurant_management_system.mapper.ClientMapper.mapToEntity;
import static com.sda.restaurant_management_system.mapper.RestaurantMapper.mapTo;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
@Override
    public void save(RestaurantDTO restaurantDTO){
    Restaurant restaurant= RestaurantMapper.mapTo(restaurantDTO);
    this.restaurantRepository.save(restaurant);
    }
    @Override
    public void update(RestaurantDTO restaurantDTO,Integer Id){
        Optional<Restaurant> restaurantOptional= restaurantRepository.findById(Id);
        if(!restaurantOptional.isPresent()){
            throw new RuntimeException("Restaurant with this Id is not found");
        }
        Restaurant restaurant=restaurantOptional.get();
        restaurant.setName(restaurantDTO.getName());
        this.restaurantRepository.save(restaurant);
    }
    @Override
     public RestaurantDTO findById(Integer Id){
        Optional<Restaurant> restaurantOptional=restaurantRepository.findById(Id);
        if(restaurantOptional.isPresent()){
            return RestaurantMapper.mapToDTO(restaurantOptional.get());

        }
        else{
            throw new RuntimeException("Restaurant with this ID"+ Id +"does not exist");

        }


    }
    @Override
    public List<RestaurantDTO> findAll(){
        List<Restaurant> restaurants=this.restaurantRepository.findAll();
        List<RestaurantDTO> restaurantDTOList=new ArrayList<>();
        for (Restaurant restaurant: restaurants){
            RestaurantDTO restaurantDTO=RestaurantMapper.mapToDTO(restaurant);
            restaurantDTOList.add(restaurantDTO);
        }
        return restaurantDTOList;

    }
    @Override
    public void delete(Integer Id){

    }





}
