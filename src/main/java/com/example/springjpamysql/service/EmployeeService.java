package com.example.springjpamysql.service;

import com.example.springjpamysql.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
}
