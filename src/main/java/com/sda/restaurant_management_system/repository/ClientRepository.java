package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {

}
