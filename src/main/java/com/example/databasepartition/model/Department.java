package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Department {
    @EmbeddedId
    private Id id;

    private String departmentName;
}
