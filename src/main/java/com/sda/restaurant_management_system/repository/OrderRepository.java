package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.Order;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface OrderRepository extends JpaRepositoryImplementation<Order,Integer > {
}
