package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Sales {
    @EmbeddedId
    private Id id;

    @NotNull
    private String orderId;

    @NotNull
    private String employeeId;

    private String totalAmt;
}
