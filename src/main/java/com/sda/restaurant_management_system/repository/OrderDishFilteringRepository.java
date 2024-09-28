package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.dto.filterDTO.FilterDTO;
import com.sda.restaurant_management_system.dto.filterDTO.FilterLogicalConnection;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.dto.filterDTO.Operator;
import com.sda.restaurant_management_system.model.DishIngredient;
import com.sda.restaurant_management_system.model.OrderDish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class OrderDishFilteringRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private  static String BASE_QUERY = "select od from OrderDish od  JOIN od.dish d where 1=1 ";

    public List<OrderDish> filter(Filters filters)
    {
        String logicalOperator = extractLogicalOperator(filters.getLogical());
        String res = BASE_QUERY;
        for (FilterDTO filterDTO : filters.getFilters()){
            res += logicalOperator + " " + "d." +filterDTO.getField() + " " + extractOperator(filterDTO.getOperator()) + " "
                    + filterDTO.getValue();
        }
        log.info("Result Query {} ", res);
        return entityManager.createQuery(res, OrderDish.class).getResultList();
    }
    private String extractLogicalOperator(FilterLogicalConnection f){
        return  switch (f) {
            case OR -> "OR";
            default  -> "AND";
        };

    }

    private String extractOperator(Operator operator) {
        return  switch (operator){
            case GREATER_THAN -> "> ";
            case GREATER_THAN_EQUAL -> ">=";
            case LESS_THAN -> "<";
            case LESS_THAN_EQUAL -> "<=";
            default -> "=";
        };
    }


}

