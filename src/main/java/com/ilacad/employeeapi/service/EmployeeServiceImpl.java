package com.ilacad.employeeapi.service;

import com.ilacad.employeeapi.entity.Employee;
import com.ilacad.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Find the list of employees
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // Save or update the employee
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Find the employee by id
    @Override
    public Employee findById(Long id) {
        return employeeRepository.
                findById(id).
                orElseThrow(() ->
                        new RuntimeException("Employee id not found - " + id)
                );
    }

    // Delete the employee by id
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
