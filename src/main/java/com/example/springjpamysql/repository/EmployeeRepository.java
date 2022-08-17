package com.example.springjpamysql.repository;

import com.example.springjpamysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// JpaRepository - provides us with CRUD DB methods

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { // Long - pk type

}
