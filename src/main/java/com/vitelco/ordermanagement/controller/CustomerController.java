package com.vitelco.ordermanagement.controller;

import com.vitelco.ordermanagement.model.Customer;
import com.vitelco.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseBody
    public List<Customer> findAll(){
        return customerService.findAll();

    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) throws NotFoundException {
        return customerService.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    @ResponseBody
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }
}
