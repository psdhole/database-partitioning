package com.example.databasepartition.service;

import com.example.databasepartition.converter.EmployeeConverter;
import com.example.databasepartition.dto.EmployeeDTO;
import com.example.databasepartition.model.Employee;
import com.example.databasepartition.model.EmployeeId;
import com.example.databasepartition.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The type Employee service.
 */
@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    /**
     * Save employee dto.
     *
     * @param employeeDTO the employee dto
     * @return the employee dto
     */
    public EmployeeDTO save(final EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.toEmployee(employeeDTO);
        Employee emp = new Employee();
        // Update existing employee when employee id is provided
        if (Objects.nonNull(employee.getEmployeeId().getId())) {
            Optional<Employee> optionalEmployee = employeeRepository.findByEmployeeId(employee.getEmployeeId());
            if (optionalEmployee.isPresent())
                emp = optionalEmployee.get();
        } else {
            EmployeeId employeeId = new EmployeeId(UUID.randomUUID(), employeeDTO.getCountryCode());
            emp.setEmployeeId(employeeId);
        }

        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setDesignation(employee.getDesignation());
        Employee savedEmployee = employeeRepository.save(emp);
        log.info("Employee Saved: {}", savedEmployee);
        return employeeConverter.toDTO(savedEmployee);
    }

    /**
     * Save all list.
     *
     * @param employeeDTOList the employee dto list
     * @return the list
     */
    public List<EmployeeDTO> saveAll(final List<EmployeeDTO> employeeDTOList) {
        // saving employees from employeeDTOLIST assuming the employees does not exist.
        if (!employeeDTOList.isEmpty()) {
            List<Employee> employeeList = employeeConverter.toEmployee(employeeDTOList);
            return employeeConverter.toDTO(employeeRepository.saveAll(employeeList));
        }
        return null;
    }

    /**
     * Gets all.
     *
     * @param pageable the pageable
     * @return the all
     */
    public Page<EmployeeDTO> getAll(final Pageable pageable) {
        return new PageImpl<>(employeeConverter
                .toDTO(employeeRepository
                        .findAll(pageable)
                        .get().collect(Collectors.toList())));
    }

    /**
     * Gets one.
     *
     * @param country    the country
     * @param employeeId the employee id
     * @return the one
     */
    public EmployeeDTO getOne(final String country, final String employeeId) {
        Optional<Employee> optionalEmployee =
                employeeRepository.findByEmployeeId(new EmployeeId(UUID.fromString(employeeId), country));
        return employeeConverter.toDTO(optionalEmployee.orElse(null));
    }

    /**
     * Delete.
     *
     * @param country    the country
     * @param employeeId the employee id
     */
    public void delete(final String country, final String employeeId) {
        Employee employee = employeeConverter.toEmployee(getOne(country, employeeId));
        employeeRepository.delete(employee);
        log.info("Employee deleted: {}", employee);
    }
}