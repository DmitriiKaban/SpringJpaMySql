package com.example.springjpamysql.repository;

import com.example.springjpamysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// JpaRepository - provides us with CRUD DB methods

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { // Long - pk type

    // spring will create query automatically
    // SELECT * FROM tbl_employee WHERE name="name"
    List<Employee> findByName(String name);

    List<Employee> findByNameAndLocation(String name, String location);
}
