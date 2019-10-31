package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Sales {
    @EmbeddedId
    private Id id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> orderList;

    @OneToOne
    private Employee employee;

    private double totalAmount;
}
