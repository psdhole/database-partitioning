package com.example.databasepartition.repository;

import com.example.databasepartition.model.Employee;
import com.example.databasepartition.model.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {

    /**
     * Find by employee id optional.
     *
     * @param employeeId the employee id
     * @return the optional
     */
    public Optional<Employee> findByEmployeeId(final EmployeeId employeeId);

}