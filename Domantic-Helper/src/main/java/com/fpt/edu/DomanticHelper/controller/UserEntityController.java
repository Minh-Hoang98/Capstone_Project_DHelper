package com.fpt.edu.DomanticHelper.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fpt.edu.DomanticHelper.entity.Identity;
import com.fpt.edu.DomanticHelper.entity.Location;

import org.apache.commons.io.FileUtils;
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
import static com.fpt.edu.DomanticHelper.ObjectHelper.Common.*;
import com.fpt.edu.DomanticHelper.entity.User;
import com.fpt.edu.DomanticHelper.payload.request.UpdateProfileRequest;
import com.fpt.edu.DomanticHelper.security.services.UserEntityServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserEntityController {

	@Autowired
	private UserEntityServiceImpl userEntityService;

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userEntityService.findAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User user = userEntityService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UpdateProfileRequest user) {
		User userService = userEntityService.findUserById(id);
		if (userService != null) {
			User newUser = new User();
			Identity newIdentity = new Identity();

			Location queQuan = covertLocation(user.getQueQuan());
			Location choO = covertLocation(user.getQueQuan());

			newUser.setAvatar(user.getAvatar());
			newIdentity.setName(user.getName());
			newIdentity.setGender(user.getGender());
			newIdentity.setDob(user.getDob());
			newIdentity.setLocationHome(covertLocation(user.getQueQuan()));
			newIdentity.setNumberIdentity(user.getSoCmnd());
			newIdentity.setDateOfIssue(user.getNgayCap());
			newIdentity.setReligion(user.getNoiCap());

			newIdentity.setImage(user.getImage1());
			newIdentity.setImage2(user.getImage2());

			newUser.setHocVan(user.getHocvan());
			newUser.setChuyenNganh(user.getChuyenNganh());
			newUser.setCurrentLocation(covertLocation(user.getNoiO()));

			newUser.setIdentityEntity(newIdentity);

			userEntityService.updateUser(newUser);
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		}
		return null;
	}
}
