package com.sda.restaurant_management_system.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
@Table(name = "klient")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
