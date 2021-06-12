package com.fpt.edu.DomanticHelper.controller;

import java.util.List;

import com.fpt.edu.DomanticHelper.entity.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.edu.DomanticHelper.entity.UserEntity;
import com.fpt.edu.DomanticHelper.service.UserEntityServiceImpl;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/users")
public class UserEntityController {

	@Autowired
    private UserEntityServiceImpl userEntityService;

	@GetMapping("/all")
	public ResponseEntity<List<UserEntity>> getAllUser () {
		List<UserEntity> users = userEntityService.findAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<UserEntity> getUserById (@PathVariable("id") int id) {
		UserEntity user = userEntityService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user) {
		UserEntity newUser = userEntityService.addUserEntity(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
		UserEntity updateUser = userEntityService.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
}
