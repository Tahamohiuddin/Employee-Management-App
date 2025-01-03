package com.example.employees.controller;

import com.example.employees.model.Employee;
import com.example.employees.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) { this.service = service; }

    @GetMapping
    public List<Employee> getAllEmployees() { return service.getAllEmployees(); }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) { return service.getEmployeeById(id); }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) { return service.addEmployee(employee); }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) { service.deleteEmployee(id); }
}
