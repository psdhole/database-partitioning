package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Product {
    @EmbeddedId
    private Id ID;

    private String NAME;

    private String PRICE;
}
