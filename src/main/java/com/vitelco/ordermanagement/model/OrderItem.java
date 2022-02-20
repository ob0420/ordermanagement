package com.vitelco.ordermanagement.model;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="orderitems")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String title;
    private int qty;
    private int price;
    private Category category;

    public OrderItem(long id, String title, int qty, int price, Category category) {
        this.id = id;
        this.title = title;
        this.qty = qty;
        this.price = price;
        this.category = category;
    }
    public enum Category {
        Electronics, Home, Food
    }

}
