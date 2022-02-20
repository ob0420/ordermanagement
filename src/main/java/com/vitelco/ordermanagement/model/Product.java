package com.vitelco.ordermanagement.model;

import lombok.Data;

@Data

public class Product {
    private long id;
    private String title;
    private int price;

    public Product(long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
}
