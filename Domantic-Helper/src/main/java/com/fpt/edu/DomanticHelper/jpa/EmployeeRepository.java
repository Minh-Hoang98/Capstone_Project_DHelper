package com.fpt.edu.DomanticHelper.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.edu.DomanticHelper.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
