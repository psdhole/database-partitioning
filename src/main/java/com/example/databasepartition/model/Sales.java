package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Sales {
    @EmbeddedId
    private Id ID;

    @NotNull
    private String ORDER_ID;

    @NotNull
    private String EMPLOYEE_ID;

    private String TOTAL_AMT;
}
