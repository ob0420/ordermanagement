package com.vitelco.ordermanagement.controller;

import com.vitelco.ordermanagement.model.Customer;
import com.vitelco.ordermanagement.model.Order;
import com.vitelco.ordermanagement.model.OrderItem;
import com.vitelco.ordermanagement.service.CustomerService;
import com.vitelco.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseBody
    public List<Order> findAll(){
        return orderService.findAll();

    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) throws NotFoundException {
        return orderService.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseBody
    public Order createOrder(@RequestBody Order order){
        return orderService.save(order);
    }
}
