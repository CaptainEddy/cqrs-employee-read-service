package com.cob.service;

import com.cob.entities.Employee;
import com.cob.repository.EmployeeReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeReadRepository employeeReadRepository;

    public Employee getEmployeeDetails(String employeeId) {
        return employeeReadRepository.findByEmployeeId(employeeId).orElse(null);
    }

    public List<Employee> getAllEmployeeDetails() {
        return employeeReadRepository.findAll();
    }

}
