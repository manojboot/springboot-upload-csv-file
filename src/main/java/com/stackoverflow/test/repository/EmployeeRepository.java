package com.stackoverflow.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackoverflow.test.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
