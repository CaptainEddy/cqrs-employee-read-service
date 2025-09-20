package com.cob.controller;

import com.cob.entities.Employee;
import com.cob.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeReadController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/getEmployee/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable String employeeId) {
        // Simulate fetching employee details from a database or external service
        return employeeService.getEmployeeDetails(employeeId);
    }

    @GetMapping(path = "/getAllEmployees")
    public List<Employee> getEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }
}
