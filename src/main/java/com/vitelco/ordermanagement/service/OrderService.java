package com.vitelco.ordermanagement.service;

import com.vitelco.ordermanagement.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();
    Order save(Order order);
    Optional<Order> findById(Long id);
}
