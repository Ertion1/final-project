package com.sda.restaurant_management_system.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dish_ingredient")
public class DishIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="id_dish", referencedColumnName = "id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name="id_ingredient", referencedColumnName = "id")
    private Ingredient ingredient;


}
