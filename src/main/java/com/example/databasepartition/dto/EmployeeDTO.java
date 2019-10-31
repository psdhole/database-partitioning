package com.example.databasepartition.dto;

import lombok.Data;

/**
 * The type Employee dto.
 */
@Data
public class EmployeeDTO {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String designation;
    private String departmentId;
    private String countryCode;
}