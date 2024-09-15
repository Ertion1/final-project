package com.sda.restaurant_management_system.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Data
public class OrderDishDTO {

        private Integer id;

        private DishDTO dish;

        private OrderDTO order;

}


