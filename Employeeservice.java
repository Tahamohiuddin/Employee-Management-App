package com.example.employees.service;

import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() { return repository.findAll(); }
    public Employee getEmployeeById(Long id) { return repository.findById(id).orElse(null); }
    public Employee addEmployee(Employee employee) { return repository.save(employee); }
    public Employee updateEmployee(Long id, Employee newEmployee) {
        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            employee.setSalary(newEmployee.getSalary());
            return repository.save(employee);
        }).orElse(null);
    }
    public void deleteEmployee(Long id) { repository.deleteById(id); }
}
