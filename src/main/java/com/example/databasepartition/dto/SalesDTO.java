package com.example.databasepartition.dto;

import lombok.Data;

@Data
public class SalesDTO {
    private String salesId;
    private String country;
    private String orderId;
    private String employeeId;
    private double totalAmount;
}