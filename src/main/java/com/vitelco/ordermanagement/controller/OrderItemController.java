package com.vitelco.ordermanagement.controller;


import com.vitelco.ordermanagement.model.OrderItem;
import com.vitelco.ordermanagement.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping
    @ResponseBody
    public List<OrderItem> findAll(){
        return orderItemService.findAll();

    }

    @GetMapping("/{id}")
    public OrderItem findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return orderItemService.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @PostMapping
    @ResponseBody
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem){
        return orderItemService.save(orderItem);
    }
}