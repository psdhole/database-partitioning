package com.example.databasepartition.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The type Employee dto.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String designation;
    private String countryCode;
}
