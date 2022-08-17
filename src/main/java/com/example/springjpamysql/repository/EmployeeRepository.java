package com.example.springjpamysql.repository;

import com.example.springjpamysql.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> { // Long - pk type

    List<Employee> findByDepartmentName(String name);

    @Query("FROM Employee WHERE department.name = :name")
    List<Employee> getEmployeesByDeptName(String name);
}
