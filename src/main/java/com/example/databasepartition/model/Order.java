package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Order {
    @EmbeddedId
    private Id ID;

    @NotNull
    private String PRODUCT_ID;

    private String QUANTITY;

    private String DISCOUNT;

    private String AMT;
}
