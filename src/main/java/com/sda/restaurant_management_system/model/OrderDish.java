package com.sda.restaurant_management_system.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="order_dish")
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name="id_dish", referencedColumnName = "id")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name="id_order", referencedColumnName = "id")
    private Order order;

}
