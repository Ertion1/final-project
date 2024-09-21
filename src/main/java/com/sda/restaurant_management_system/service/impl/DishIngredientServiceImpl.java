package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.DishIngredientDTO;
import com.sda.restaurant_management_system.mapper.DishIngredientMapper;
import com.sda.restaurant_management_system.model.Dish;
import com.sda.restaurant_management_system.model.DishIngredient;
import com.sda.restaurant_management_system.model.Ingredient;
import com.sda.restaurant_management_system.repository.DishIngredientRepository;
import com.sda.restaurant_management_system.repository.DishRepository;
import com.sda.restaurant_management_system.repository.IngredientRepository;
import com.sda.restaurant_management_system.service.DishIngredientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DishIngredientServiceImpl implements  DishIngredientService {
    @Autowired
    private DishIngredientRepository dishIngredientRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void save(DishIngredientDTO dishIngridientDTO) {
        Integer dishID = dishIngridientDTO.getDish().getId();
        Integer ingredientID= dishIngridientDTO.getIngredient().getId();

        Optional<Dish> dishOptional = dishRepository.findById(dishID);
        Optional<Ingredient> ingredientOptional = ingredientRepository.findById(ingredientID);

        if(dishOptional.isPresent() && ingredientOptional.isPresent())
        {
            DishIngredient dishIngredient = DishIngredientMapper.mapToEntity(dishOptional.get(),ingredientOptional.get());
            this.dishIngredientRepository.save(dishIngredient);

        }else
        {
            throw new RuntimeException("Author or book doesn't exist");
        }


    }

    @Override
    public void update(DishIngredientDTO dishIngridientDTO, Integer id) {
  // eshte me e thjeshte ta fish dhe me pas ta krijosh nje rekord sesa ti besh update

        throw new RuntimeException("Not implemented");
    }

    @Override
    public DishIngredientDTO findById(Integer id) {
        Optional<DishIngredient> dishIngredient = dishIngredientRepository.findById(id);
        if(dishIngredient.isPresent())
        {
            return DishIngredientMapper.mapToDTO(dishIngredient.get());
        }
        else
        {
            throw new RuntimeException("DishIngredient record not present");
        }

    }

    @Override
    public List<DishIngredientDTO> findAll() {
        return dishIngredientRepository.findAll().stream().map(DishIngredientMapper::mapToDTO).toList();
    }

    @Override
    public void delete(Integer id) {
     this.dishIngredientRepository.deleteById(id);
    }
}
