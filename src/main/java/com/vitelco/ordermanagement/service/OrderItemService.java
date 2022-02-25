package com.vitelco.ordermanagement.service;

import com.vitelco.ordermanagement.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    List<OrderItem> findAll();
    OrderItem save(OrderItem orderItem);
    Optional<OrderItem> findById(Long id);
}
