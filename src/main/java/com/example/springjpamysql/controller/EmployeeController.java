package com.example.springjpamysql.controller;

import com.example.springjpamysql.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// handles the http request
@RestController
public class EmployeeController {

    // values from application.properties
    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails(){
        return appName + " - " + appVersion;
    }

    // localhost:8080/employees
    @GetMapping("/employees")
    public String getEmployees(){
        return "displaying list of employees";
    }

    // localhost:8080/employees/73
    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable Long id){
        return "Fetching the employee details for the id " + id;
    }

    // Handler method, receives Employee details
    @PostMapping("employees")
    public String saveEmployee(@RequestBody Employee employee){
        return "Saving the employee details to the DB " + employee;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("updating the employee data for the id " + id);
        return employee;
    }

    // localhost:8080/employees?id=34
    // we can check if worked in postman
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam("id") Long id){ // "id" - var name in url
        return "Deleting the employee by id " + id;
    }

}
