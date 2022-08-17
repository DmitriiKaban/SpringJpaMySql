package com.example.springjpamysql.controller;

import com.example.springjpamysql.model.Employee;
import com.example.springjpamysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// handles the http request
@RestController
//@RequestMapping("/api/v1") // localhost:8080/api/v1/employees

public class EmployeeController {
    @Autowired
    private EmployeeService eService; // as soon as project starts the object will be injected

    // localhost:8080/employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return eService.getEmployees();
    }

    // localhost:8080/employees/73
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return eService.getSingleEmployee(id);
    }

    // Handler method, receives Employee details
    @PostMapping("employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return eService.saveEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("updating the employee data for the id " + id);
        return employee;
    }

    // localhost:8080/employees?id=34
    // we can check if worked in postman
    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long id){ // "id" - var name in url
        eService.deleteEmployee(id);
    }

}
