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
import com.fpt.edu.DomanticHelper.security.services.IdentityEntityServiceImpl;
import com.fpt.edu.DomanticHelper.security.services.LocationEntityServiceImpl;
import com.fpt.edu.DomanticHelper.security.services.UserEntityServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserEntityController {

	@Autowired
	private UserEntityServiceImpl userEntityService;

	@Autowired
	private LocationEntityServiceImpl locationEntityService;

	@Autowired
	private IdentityEntityServiceImpl identityEntityService;

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

	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UpdateProfileRequest userRequest) {
		User oldUser = userEntityService.findUserById(id);
		if (oldUser != null) {

			Identity oldIdentity = oldUser.getIdentityEntity();
			Location oldQueQuan = oldUser.getIdentityEntity().getLocationHome();
			Location oldeChoO = oldUser.getCurrentLocation();

			Location newqueQuan = covertLocation(userRequest.getQueQuan());
			newqueQuan.setIdLocation(oldQueQuan.getIdLocation());
			locationEntityService.updateLocation(newqueQuan);

			Location newChoO = covertLocation(userRequest.getQueQuan());
			newChoO.setIdLocation(oldeChoO.getIdLocation());
			locationEntityService.updateLocation(newChoO);

			oldIdentity.setName(userRequest.getName());
			oldIdentity.setGender(userRequest.getGender());
			oldIdentity.setDob(userRequest.getDob());
			oldIdentity.setLocationHome(newqueQuan);
			oldIdentity.setNumberIdentity(userRequest.getSoCmnd());
			oldIdentity.setDateOfIssue(userRequest.getNgayCap());
			oldIdentity.setReligion(userRequest.getNoiCap());

			oldIdentity.setImage(userRequest.getImage1());
			oldIdentity.setImage2(userRequest.getImage2());

			oldUser.setAvatar(userRequest.getAvatar());
			oldUser.setHocVan(userRequest.getHocvan());
			oldUser.setChuyenNganh(userRequest.getChuyenNganh());
			oldUser.setCurrentLocation(newChoO);

			oldUser.setIdentityEntity(oldIdentity);

			identityEntityService.updateIdentity(oldIdentity);
			userEntityService.updateUser(oldUser);
			return new ResponseEntity<>(oldUser, HttpStatus.OK);
		}

		return null;
	}
	
	@PostMapping("/add/{id}")
	public ResponseEntity<User> addUser(@PathVariable("id") int id, @RequestBody UpdateProfileRequest userRequest) {
		User newUser = userEntityService.findUserById(id);
		if (newUser != null) {
			Location newqueQuan = covertLocation(userRequest.getQueQuan());			
			locationEntityService.addLocationEntity(newqueQuan);

			Location newChoO = covertLocation(userRequest.getQueQuan());
			locationEntityService.addLocationEntity(newChoO);
			Identity newIdentity = new Identity( userRequest.getSoCmnd(), userRequest.getImage1(), userRequest.getImage2(), userRequest.getName(), 
					userRequest.getGender(), userRequest.getDob(), "Việt Nam","Không", "Nốt ruồi mắt trái", userRequest.getNgayCap(), newqueQuan, newUser);

			newUser.setAvatar(userRequest.getAvatar());
			newUser.setChuyenNganh(userRequest.getChuyenNganh());
			newUser.setHocVan(userRequest.getHocvan());
			identityEntityService.add(newIdentity);
			userEntityService.updateUser(newUser);
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		}

		return null;
	}
}
