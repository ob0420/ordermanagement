package com.vitelco.ordermanagement;

import com.vitelco.ordermanagement.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class OrdermanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(OrdermanagementApplication.class, args);

		/* Customer customer = new Customer(1, "Olya", "Babakulyyeva");
		Customer customer2 = new Customer(2, "Can", "Ozturk");

		OrderItem itm1 = new OrderItem(1, "iphone", 1, 15000, OrderItem.Category.Electronics);
		OrderItem itm2 = new OrderItem(2, "samsung", 2, 8000, OrderItem.Category.Electronics);
		OrderItem itm3 = new OrderItem(3, "keyboard", 1, 150, OrderItem.Category.Electronics);

		Set items = new HashSet();
		items.add(itm1);
		items.add(itm2);
		Order order = new Order(1, customer, items);
		log.info("Orders: {}", order); */
	}

}
