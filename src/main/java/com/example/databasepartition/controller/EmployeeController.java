package com.example.databasepartition.controller;

import com.example.databasepartition.dto.EmployeeDTO;
import com.example.databasepartition.model.Employee;
import com.example.databasepartition.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Gets all.
     *
     * @param pageable the pageable
     * @return the all
     */
    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> getAll(final Pageable pageable) {
        return ResponseEntity.ok(employeeService.getAll(pageable));
    }

    /**
     * Gets one.
     *
     * @param country the country
     * @param id      the id
     * @return the one
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getOne(final @PathVariable String country, final @PathVariable String id) {
        return ResponseEntity.ok(employeeService.getOne(country, id));
    }

    /**
     * Save response entity.
     *
     * @param employeeDTO the employee dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Employee> save(final @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity(employeeService.save(employeeDTO), HttpStatus.CREATED);
    }

    /**
     * Update response entity.
     *
     * @param employeeDTO the employee dto
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity<EmployeeDTO> update(final @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.save(employeeDTO));
    }

    /**
     * Delete response entity.
     *
     * @param country the country
     * @param id      the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(final @PathVariable String country, final @PathVariable String id) {
        employeeService.delete(country, id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}