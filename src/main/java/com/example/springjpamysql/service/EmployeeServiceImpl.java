package com.example.springjpamysql.service;

import com.example.springjpamysql.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static List<Employee> list = new ArrayList<>();
    static {
        Employee e = new Employee();
        e.setName("Navin");
        e.setAge(38L);
        e.setDepartment("IT");
        e.setEmail("navin@gmail.com");
        e.setLocation("Egypt");

        list.add(e);

        e = new Employee();
        e.setName("Valera");
        e.setAge(17L);
        e.setDepartment("Textile");
        e.setEmail("valera@gmail.com");
        e.setLocation("Bali");

        list.add(e);
    }

    @Override
    public List<Employee> getEmployees() {
        return list;
    }
}
