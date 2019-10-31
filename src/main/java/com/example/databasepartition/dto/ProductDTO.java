package com.example.databasepartition.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String productId;
    private String productName;
    private double price;
    private String country;
}