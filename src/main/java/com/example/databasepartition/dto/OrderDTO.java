package com.example.databasepartition.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderId;
    private String productId;
    private long qunatity;
    private double discount;
    private double amount;
    private String salesId;
}