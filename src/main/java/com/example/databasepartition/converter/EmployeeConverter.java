package com.example.databasepartition.converter;

import com.example.databasepartition.dto.EmployeeDTO;
import com.example.databasepartition.model.Employee;
import com.example.databasepartition.model.EmployeeId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Employee converter.
 */
@Component
public class EmployeeConverter {

    /**
     * To employee employee.
     *
     * @param dto the dto
     * @return the employee
     */
    public Employee toEmployee(final EmployeeDTO dto) {
        Employee employee = new Employee();
        EmployeeId employeeId = null;

        if (Objects.nonNull(dto.getId())) {
            if (Objects.isNull(employeeId))
                employeeId = new EmployeeId();
            employeeId.setId(UUID.fromString(dto.getId()));
        }
        if (Objects.nonNull(dto.getCountryCode())) {
            if (Objects.isNull(employeeId))
                employeeId = new EmployeeId();
            employeeId.setCountry(dto.getCountryCode());
        }
        if (Objects.nonNull(dto.getFirstName())) {
            employee.setFirstName(dto.getFirstName().trim());
        }
        if (Objects.nonNull(dto.getLastName())) {
            employee.setLastName(dto.getLastName().trim());
        }
        if (Objects.nonNull(dto.getDesignation())) {
            employee.setDesignation(dto.getDesignation());
        }
        employee.setEmployeeId(employeeId);
        return employee;
    }

    /**
     * To employee list.
     *
     * @param dtoList the dto list
     * @return the list
     */
    public List<Employee> toEmployee(final List<EmployeeDTO> dtoList) {
        return dtoList.parallelStream().map(this::toEmployee).collect(Collectors.toList());
    }

    /**
     * To dto employee dto.
     *
     * @param employee the employee
     * @return the employee dto
     */
    public EmployeeDTO toDTO(final Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getEmployeeId().getId().toString());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setDesignation(employee.getDesignation());
        dto.setCountryCode(employee.getEmployeeId().getCountry());
        return dto;
    }

    /**
     * To dto list.
     *
     * @param employeeList the employee list
     * @return the list
     */
    public List<EmployeeDTO> toDTO(final List<Employee> employeeList) {
        return employeeList.parallelStream().map(this::toDTO).collect(Collectors.toList());
    }

}
