package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.DishIngredientDTO;
import com.sda.restaurant_management_system.dto.RestaurantDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.mapper.DishIngredientMapper;
import com.sda.restaurant_management_system.mapper.RestaurantMapper;
import com.sda.restaurant_management_system.model.Dish;
import com.sda.restaurant_management_system.model.DishIngredient;
import com.sda.restaurant_management_system.model.Ingredient;
import com.sda.restaurant_management_system.model.OrderDish;
import com.sda.restaurant_management_system.repository.*;
import com.sda.restaurant_management_system.service.DishIngredientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class DishIngredientServiceImpl implements  DishIngredientService {

    private final DishIngredientRepository dishIngredientRepository;
    private final DishIngredientFilteringRepository dishIngredientFilteringRepository;
    private final OrderDishRepository orderDishRepository;
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
    @Override
    public List<DishIngredientDTO> filter(Filters filters) {
        return dishIngredientFilteringRepository.filter(filters).stream().
                map(DishIngredientMapper::mapToDTO).toList();
    }

    @Override
    public List<Ingredient> findMostUsedIngredients() {
        List<DishIngredient> allDishIngredients = dishIngredientRepository.findAll();
        List<Dish> allDishes = dishRepository.findAll();
        Map<Dish , Integer> dishCount = new HashMap<>();



        for(Dish d : allDishes)
        {
            List<OrderDish> ordersOfDish= orderDishRepository.findAllByDishId(d.getId());
            dishCount.put(d,ordersOfDish.size());
        }
        Stream<Map.Entry<Dish,Integer>> sorted =
                dishCount.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
       List<Dish> countedDishes = new ArrayList<>();
        int count=0;

        for(Map.Entry<Dish,Integer> stream:sorted.toList())
        {
            if(count>9) {
                break;
            }
                countedDishes.add(stream.getKey());
                count++;
        }

        Set<Ingredient> ingredients = new HashSet<>();

        for (Dish d : allDishes)
        {
            List<Ingredient> ingredientsOfDishes=dishIngredientRepository
                    .findAllByDishId(d.getId()).stream().map(DishIngredient::getIngredient).toList();
            ingredients.addAll(ingredientsOfDishes);
        }

        return new ArrayList<>(ingredients) ;

    }

}
