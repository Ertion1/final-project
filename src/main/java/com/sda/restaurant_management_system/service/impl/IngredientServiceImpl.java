package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.IngredientDTO;
import com.sda.restaurant_management_system.dto.IngredientDTO;
import com.sda.restaurant_management_system.mapper.IngredientMapper;
import com.sda.restaurant_management_system.mapper.IngredientMapper;
import com.sda.restaurant_management_system.model.Ingredient;
import com.sda.restaurant_management_system.repository.IngredientRepository;
import com.sda.restaurant_management_system.service.IngredientService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService{

    private final IngredientRepository ingredientRepository;



    public IngredientServiceImpl (IngredientRepository ingredientRepository){
        this.ingredientRepository=ingredientRepository;
    }

    @Override
    public void save(IngredientDTO ingridientDTO) {
        Ingredient ingredient = IngredientMapper.mapToEntity(ingridientDTO);
        this.ingredientRepository.save(ingredient);
    }

    @Override
    public void update(IngredientDTO ingredientDTO, Integer id) {
        Optional<Ingredient> ingredientOpt=ingredientRepository.findById(id);
        if(!ingredientOpt.isPresent()){
            throw new RuntimeException("Igridient whith this id not found");
        }
        Ingredient ingredient= ingredientOpt.get();
        ingredient.setName(ingredientDTO.getName());
        this.ingredientRepository.save(ingredient);
    }
    @Override
    public IngredientDTO findById(Integer id) {
        Optional<Ingredient>ingredientOptional=ingredientRepository.findById(id);
        if (ingredientOptional.isPresent()){
            return IngredientMapper.mapToDTO(ingredientOptional.get());
        }else{
            throw new RuntimeException("Ingridient with id"+id+"does not exis");
        }

    }

    @Override
    public List<IngredientDTO> findAll(){
        List<Ingredient> ingredient=this.ingredientRepository.findAll();
        List<IngredientDTO> ingridientDTOList=new ArrayList<>();
        for (Ingredient restaurant: ingredient){
            IngredientDTO restaurantDTO= IngredientMapper.mapToDTO((Ingredient) ingredient);
            ingridientDTOList.add(restaurantDTO);
        }
        return ingridientDTOList;

    }
    @Override
    public void delete(Integer Id){

    }
}
