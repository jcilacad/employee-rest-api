package com.ilacad.employeeapi.rest;

import com.ilacad.employeeapi.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    // Get List of all employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return null;
    }
}
