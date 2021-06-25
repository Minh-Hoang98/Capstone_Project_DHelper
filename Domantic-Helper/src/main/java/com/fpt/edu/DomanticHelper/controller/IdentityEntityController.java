package com.fpt.edu.DomanticHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.edu.DomanticHelper.entity.Identity;

@RestController
public class IdentityEntityController {
//
//	@Autowired
//    private IdentityEntityService identityEntityService;
//	
//	// expose "/user" and return list of user
//	@GetMapping("/identities")
//	public List<IdentityEntity> findAll() {
//		return identityEntityService.findAll();
//	}
//
//	// add mapping for GET /user/{userId}
//	
//	@GetMapping("/identities/{identityId}")
//	public IdentityEntity getIdentity(@PathVariable int identityId) {
//		
//		IdentityEntity theIdentity = identityEntityService.findById(identityId);
//		
//		if (theIdentity == null) {
//			throw new RuntimeException("Identity id not found - " + identityId);
//		}
//		
//		return theIdentity;
//	}
//	
//	// add mapping for POST /user - add new user
//	
//	@PostMapping("/identities")
//	public IdentityEntity addUser(@RequestBody IdentityEntity theIdentity) {
//		
//		theIdentity.setIdIdentity(0);	
//		identityEntityService.save(theIdentity);
//		
//		return theIdentity;
//	}
//	
//	// add mapping for PUT /users - update existing users
//	
//	@PutMapping("/identities")
//	public IdentityEntity updateUser(@RequestBody IdentityEntity theIdentity) {
//		
//		identityEntityService.save(theIdentity);
//		
//		return theIdentity;
//	}

}
