package com.sda.restaurant_management_system.mapper;

import com.sda.restaurant_management_system.dto.ClientDTO;
import com.sda.restaurant_management_system.model.Client;

public class ClientMapper {

    public static Client mapToEntity(ClientDTO clientDTO){
        Client client=new Client();
        client.setName(clientDTO.getName());
        return client;
    }

    public static ClientDTO mapToDTO(Client clientEntity){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName(clientEntity.getName());
        clientDTO.setId(clientEntity.getId());
        clientDTO.setLastName(clientEntity.getLastName());
        clientDTO.setPhoneNumber(clientEntity.getPhoneNumber());
        clientDTO.setAddress(clientEntity.getAddress());
        clientDTO.setCity(clientEntity.getCity());
        clientDTO.setEmail(clientEntity.getEmail());
        clientDTO.setPassword(clientDTO.getPassword());
        return clientDTO;
    }

}
