package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Order {
    @EmbeddedId
    private Id id;

    @NotNull
    private String productId;

    private String quantity;

    private String discount;

    private String amt;
}
