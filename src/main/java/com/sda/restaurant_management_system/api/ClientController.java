package com.sda.restaurant_management_system.api;

import com.sda.restaurant_management_system.dto.ClientDTO;
import com.sda.restaurant_management_system.dto.filterDTO.Filters;
import com.sda.restaurant_management_system.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Filter;

@RestController
@RequestMapping ( "/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public void save (@RequestBody ClientDTO clientDTO){
        clientService.save(clientDTO);
    }

    @PutMapping ("/{id}")
    public void update(@RequestBody ClientDTO clientDTO , @PathVariable("id") Integer Id){
      clientService.update(clientDTO , Id);
    }
    @GetMapping("/{id}")
        public ClientDTO findbyId(@PathVariable("id") Integer id){
        return clientService.findbyID(id);
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @DeleteMapping ("/{id}")
    public void delete (@PathVariable Integer id) {
        clientService.delete(id);
    }

    @PostMapping ("/filter")
    public List<ClientDTO> filter(@RequestBody Filters filters){
        return clientService.filter(filters);
    }

}
