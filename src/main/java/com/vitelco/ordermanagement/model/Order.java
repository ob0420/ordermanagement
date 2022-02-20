package com.vitelco.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

public class Order implements Serializable {

    // property, state, field = class member
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime createdDate;
    private float amount;
    private float vat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerid", nullable = false)
    private Customer customer;

    @OneToMany
    private Set<OrderItem> items;

    public Order(long id, Customer customer, Set<OrderItem> items) {
        this.id = id;
        this.createdDate = LocalDateTime.now();
        this.customer = customer;
        this.items = items;
        this.amount = this.calcTotalPrice();
        this.vat = this.calcTotalVat();
    }

    public float calcTotalPrice() {
        if (this.getItems().size() == 0) {
            log.warn("There is no Order item");
            return 0f;
        }

        float total = 0f;
        for (OrderItem item : this.getItems()) {
            total += item.getPrice() * item.getQty();
        }
        return total;
    }
    public float calcTotalVat(){
        if (this.getItems().size() == 0) {
            log.warn("There is no Order item");
            return 0f;
        }
        float totalVat = 0f;
        for (OrderItem item : this.getItems()) {
            totalVat += item.getPrice() * 0.18;
        }
        return totalVat;

    }
}
