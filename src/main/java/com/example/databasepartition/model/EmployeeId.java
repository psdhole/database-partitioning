package com.example.databasepartition.model;

import com.example.databasepartition.util.DBPartitioningUtil;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import org.hibernate.id.UUIDGenerator;

/**
 * The type Employee id.
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmployeeId implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO, generator = DBPartitioningUtil.UUID)
    @GenericGenerator(name = DBPartitioningUtil.UUID,
            strategy = DBPartitioningUtil.UUID_GENERATOR_CLASS,
            parameters = {
                    @Parameter(name = UUIDGenerator.UUID_GEN_STRATEGY_CLASS,
                            value = DBPartitioningUtil.CUSTOM_VERSION_ONE_STRATEGY)
            })
    private UUID id;

    private String country;
}
