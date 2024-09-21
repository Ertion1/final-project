package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.dto.filterDTO.FilterDTO;
import com.sda.restaurant_management_system.dto.filterDTO.FilterLogicalConnection;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.dto.filterDTO.Operator;
import com.sda.restaurant_management_system.model.Dish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class DishFilteringRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private static String BASE_QUERY = "select d from Dish d where 1=1 ";
    public List<Dish> filter(Filters filters){
        String logicaloperator=extractLogicalOperator(filters.getLogical());
        String res = BASE_QUERY;
        for (FilterDTO filterDTO : filters.getFilters()){
            res += logicaloperator + " " + filterDTO.getField() + " "
                    + extractOperator(filterDTO.getOperator())+ " " + extractValue(filterDTO.isText(),
                    filterDTO.getValue());

        }
        log.info("Result Query {}",res);
        return entityManager.createQuery(res, Dish.class).getResultList();
    }

    private String extractValue(boolean text, String value) {
        return text ? "'" + value + "'" : value;
    }
    private String extractLogicalOperator(FilterLogicalConnection f){
        return switch (f){
            case OR -> "OR";
            default -> "AND";
        };

    }
    private String extractOperator(Operator operator) {
        return switch (operator) {
            case GREATER_THAN -> ">";
            case GREATER_THAN_EQUAL -> ">=";
            case LESS_THAN -> "<";
            case LESS_THAN_EQUAL -> "<=";
            default -> "=";
        };
    }
}
