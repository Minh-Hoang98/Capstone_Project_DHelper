package com.fpt.edu.DomanticHelper.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.entity.Employee;
import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import com.fpt.edu.DomanticHelper.jpa.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee by id " + id + " was not found"));
    }
}
