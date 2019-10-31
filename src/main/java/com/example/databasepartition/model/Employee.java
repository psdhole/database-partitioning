package com.example.databasepartition.model;

import lombok.Data;

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
    private Id id;

    @NotNull
    private String firstName;

    private String lastName;

    private String designation;

    private Department department;
}