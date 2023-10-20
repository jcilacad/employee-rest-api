package com.ilacad.employeeapi.service;

import com.ilacad.employeeapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee save(Employee employee);

    Employee findById(Long id);

    void deleteById(Long id);
}
