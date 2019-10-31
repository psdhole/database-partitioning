package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity
public class Order {
    @EmbeddedId
    private Id id;

    @OneToOne
    private Product product;

    private long quantity;

    private double discount;

    private double amount;
}
