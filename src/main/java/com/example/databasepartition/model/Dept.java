package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class Dept {
    @EmbeddedId
    private Id id;

    private String deptName;
}
