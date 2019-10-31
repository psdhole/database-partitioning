package com.example.databasepartition.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 * The type Employee id.
 */
@Data
@Embeddable
public class Id implements Serializable {

    private UUID id;

    private String country;
}
