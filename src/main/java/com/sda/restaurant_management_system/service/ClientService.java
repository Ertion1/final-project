package com.sda.restaurant_management_system.service;

import com.sda.restaurant_management_system.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    void save (ClientDTO clientDTO);
    void update (ClientDTO clientDTO , Integer Id);

    ClientDTO findbyID(Integer Id);
    List<ClientDTO>findAll();
    void delete(Integer Id);
}
