package com.momenton.codechallenge.companyhierarchy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.momenton.codechallenge.companyhierarchy.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    @Query("select emp from Employee emp where emp.manager is null")
    /**
     * This method returns a list as there can be multiple top level employees.
     * If anyone without a manager is considered as a top level employee.
     * 
     * @return
     */
    List<Employee> findTopLevel();
}
