package com.cob.repository;

import com.cob.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeReadRepository extends JpaRepository<Employee, Long> {
    public abstract Optional<Employee> findByEmployeeId(String employeeId);
}
