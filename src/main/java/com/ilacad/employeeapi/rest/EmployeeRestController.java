package com.ilacad.employeeapi.rest;

import com.ilacad.employeeapi.entity.Employee;
import com.ilacad.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Get the list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable Long employeeId) {

        // Find employee by id
        Employee employee = employeeService.findById(employeeId);

        // return the employee
        return employee;
    }


    // Add Employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        // Set the employee id to 0 to specifically make use the create function
        employee.setId(0L);

        Employee dbEmployee = employeeService.save(employee);

        return dbEmployee;
    }


    // Mapping for updating an employee details
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        // Update employee
        Employee updatedEmployee = employeeService.save(employee);

        return updatedEmployee;
    }

    // Mapping for deleting an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {

        // Check if the id exists, throw if it does not exists
        employeeService.findById(employeeId);

        // Delete employee if exists
        employeeService.deleteById(employeeId);

        return "Successfully deleted employee with employee id - " + employeeId;
    }

}
