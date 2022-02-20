package com.vitelco.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastName = lastname;
    }

    public String placeOrder(){
        return "Musteri: " + this.toString() + " bir siparis olusturdu";
    }

}
