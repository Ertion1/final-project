package com.sda.restaurant_management_system.service.impl;

import com.sda.restaurant_management_system.dto.ClientDTO;
import com.sda.restaurant_management_system.mapper.ClientMapper;
import com.sda.restaurant_management_system.model.Client;
import com.sda.restaurant_management_system.repository.ClientRepository;
import com.sda.restaurant_management_system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    private ClientRepository clientRepository;

    public  ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public  void save (ClientDTO clientDTO){
        Client client = ClientMapper.mapToEntity(clientDTO);
        this.clientRepository.save(client);

    }

    @Override
    public  void update (ClientDTO clientDTO , Integer Id){
        Optional<Client> clientOpt = clientRepository.findById(Id);

        if (!clientOpt.isPresent()) {
            throw  new RuntimeException("Client with this ID is not found!");
        }
Client client = clientOpt.get();
        client.setName(clientDTO.getName());

        this.clientRepository.save(client);
    }

    @Override
    public ClientDTO findbyID(Integer Id){
    Optional<Client> clientOptional = clientRepository.findById(Id);
    if (clientOptional.isPresent()){
        return ClientMapper.mapToDTO(clientOptional.get());
    }
    else {
        throw new RuntimeException("Client with this Id:" + Id + "does not exist");
    }
    }

    @Override

    public List<ClientDTO> findAll(){
 List<Client > clients= this.clientRepository.findAll();

 List<ClientDTO> clientDTOsList= new ArrayList<>();

 for (Client client :clients){
     ClientDTO clientDTO = ClientMapper.mapToDTO(client);
     clientDTOsList.add(clientDTO);
 }
 return clientDTOsList;
    }

    @Override
    public void delete(Integer Id){

    }
}
