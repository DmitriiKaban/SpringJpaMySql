package com.example.springjpamysql.controller;

import com.example.springjpamysql.model.Employee;
import com.example.springjpamysql.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// handles the http request
@RestController
//@RequestMapping("/api/v1") // localhost:8080/api/v1/employees

public class EmployeeController {
    @Autowired
    private EmployeeService eService; // as soon as project starts the object will be injected

    // localhost:8080/employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(eService.getEmployees(), HttpStatus.OK);
    }

    // localhost:8080/employees/73
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    // Handler method, receives Employee details
    // @Valid checks if selected in Entity props are validated and throws exception
    @PostMapping("employees")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // localhost:8080/employees/33
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<>(eService.updateEmployee(employee), HttpStatus.OK);
    }

    // localhost:8080/employees?id=34
    // we can check if worked in postman
    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("id") Long id){ // "id" - var name in url
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<>(eService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByNameAndLocation")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name, @RequestParam String location){
        return new ResponseEntity<>(eService.getEmployeesByNameAndLocation(name, location), HttpStatus.OK);
    }

    @GetMapping("/employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<>(eService.getEmployeesByKeyWord(name), HttpStatus.OK);
    }

}
