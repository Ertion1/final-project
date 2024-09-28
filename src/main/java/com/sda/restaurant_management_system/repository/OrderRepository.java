package com.sda.restaurant_management_system.repository;

import com.sda.restaurant_management_system.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public interface OrderRepository extends JpaRepositoryImplementation<Order,Integer > {
    @Query("select o from Order o order by o.totalPrice desc")
    List<Order> findAllSortedByPrice();
}
