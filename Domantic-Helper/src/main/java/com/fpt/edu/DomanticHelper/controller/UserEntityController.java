package com.fpt.edu.DomanticHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.edu.DomanticHelper.entity.UserEntity;
import com.fpt.edu.DomanticHelper.service.UserEntityService;

@RestController
@RequestMapping("/api")
public class UserEntityController {

	@Autowired
    private UserEntityService userEntityService;
	
	// expose "/user" and return list of user
	@GetMapping("/users")
	public List<UserEntity> findAll() {
		return userEntityService.findAll();
	}

	// add mapping for GET /user/{userId}
	
	@GetMapping("/users/{userId}")
	public UserEntity getUser(@PathVariable String userId) {
		
		UserEntity theUser = userEntityService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		return theUser;
	}
	
	// add mapping for POST /user - add new user
	
	@PostMapping("/users")
	public UserEntity addUser(@RequestBody UserEntity theUser) {
		
		theUser.setId("");	
		userEntityService.save(theUser);
		
		return theUser;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/users")
	public UserEntity updateUser(@RequestBody UserEntity theUser) {
		
		userEntityService.save(theUser);
		
		return theUser;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable String userId) {
		
		UserEntity tempUserEntity = userEntityService.findById(userId);
		
		// throw exception if null
		
		if (tempUserEntity == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userEntityService.deleteById(userId);
		
		return "Deleted User id - " + userId;
	}
}