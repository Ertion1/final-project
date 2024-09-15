package com.sda.restaurant_management_system.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClientDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String email;
    private String password;
}
