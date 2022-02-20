package com.vitelco.ordermanagement.service;

import com.vitelco.ordermanagement.model.Customer;
import com.vitelco.ordermanagement.model.Order;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    boolean login(Customer customer);
    List<Customer> findAll();
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);

}
