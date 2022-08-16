package com.example.springjpamysql.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// handles the http request
@RestController
public class EmployeeController {

    // localhost:8080/employees
    @GetMapping("/employees")
    public String getEmployees(){
        return "displaying list of employees";
    }

    // localhost:8080/employees/73
    @GetMapping("/employees/{id}")
    public String getEmployee(@PathVariable("id") Long id){
        return "Fetching the employee details for the id " + id;
    }

}
