package com.example.springjpamysql.controller;

import com.example.springjpamysql.model.Department;
import com.example.springjpamysql.model.Employee;
import com.example.springjpamysql.repository.DepartmentRepository;
import com.example.springjpamysql.repository.EmployeeRepository;
import com.example.springjpamysql.request.EmployeeRequest;
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

    @Autowired
    private EmployeeRepository eRepo;
    @Autowired
    private DepartmentRepository dRepo;

    // localhost:8080/employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam int pageNumber, @RequestParam int pageSize){
        return new ResponseEntity<>(eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
    }

    // localhost:8080/employees/73
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    // Handler method, receives Employee details
    // @Valid checks if selected in Entity props are validated and throws exception
    @PostMapping("employees")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest){

        Employee employee = new Employee(eRequest);
        employee = eRepo.save(employee);

        for(String s : eRequest.getDepartment()){
            Department d = new Department();
            d.setName(s);
            d.setEmployee(employee);

            dRepo.save(d);
        }
        return new ResponseEntity<>("Record saved successfully", HttpStatus.CREATED);
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

}
