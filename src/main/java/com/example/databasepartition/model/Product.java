package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Product {
    @EmbeddedId
    private Id id;

    private String name;

    private String price;
}
