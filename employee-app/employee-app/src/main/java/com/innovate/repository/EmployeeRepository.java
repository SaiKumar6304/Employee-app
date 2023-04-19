package com.innovate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innovate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
