package com.cob.kafka;

import com.cob.entities.Employee;
import com.cob.entities.EmployeeDTO;
import com.cob.repository.EmployeeReadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeReadKafkaListener {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeReadKafkaListener.class);
    @Autowired
    private EmployeeReadRepository employeeReadRepository;

    @KafkaListener(topics = "${custom.kafka.topic.employee.response-employee-topic}", groupId = "custom.kafka.topic.employee.employee-group")
    public void consumeEmployeeWriteServiceEvent(EmployeeDTO employeeDTO) {
        LOG.info("Employee Data has been consumed");

        Employee employee = new Employee();

        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setPosition(employeeDTO.getPosition());
        employee.setSalary(employeeDTO.getSalary());
        employee.setName(employeeDTO.getName());


        Employee savedEmployee = employeeReadRepository.save(employee);
        LOG.info("{}", savedEmployee);
    }

}
