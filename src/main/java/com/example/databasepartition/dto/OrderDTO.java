package com.example.databasepartition.dto;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderId;
    private String productId;
    private String qunatity;
    private String discount;
    private String amt;
    private String salesId;
}
