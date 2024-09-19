package com.sda.restaurant_management_system.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data @NoArgsConstructor
@Table(name="restaurant_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="price_total")
    private  Integer totalPrice ;

    @OneToOne
    @JoinColumn(name="id_restaurant" , referencedColumnName = "id")
    private Restaurant restaurant;

    @OneToOne
    @JoinColumn(name="id_client" , referencedColumnName = "id")
    private Client client;


}
