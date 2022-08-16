package com.example.springjpamysql.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller // handles Http requests
@RestController // @Controller + @ResponseBody
public class EmployeeController {

    // localhost:8080/employees
    //@RequestMapping(value = "/employees", method = RequestMethod.GET)
    //@ResponseBody // if we use only @Controller @RequestMapping
    @GetMapping("/employees") // instead of
    public String getEmployees(){
        return "displaying list of employees";
    }
}
