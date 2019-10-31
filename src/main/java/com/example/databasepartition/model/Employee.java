package com.example.databasepartition.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * The type Employee.
 */
@Entity
@Data
public class Employee {

    @EmbeddedId
    private Id ID;

    @NotNull
    private String FIRST_NAME;

    private String LAST_NAME;

    private String DESIGNATION;

    private String DEPT_ID;
}