package com.fpt.edu.DomanticHelper.controller;

import static com.fpt.edu.DomanticHelper.ObjectHelper.Common.covertLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fpt.edu.DomanticHelper.entity.HelperJob;
import com.fpt.edu.DomanticHelper.entity.Location;
import com.fpt.edu.DomanticHelper.entity.Post;
import com.fpt.edu.DomanticHelper.entity.User;
import com.fpt.edu.DomanticHelper.security.jwt.FindJobRequest;
import com.fpt.edu.DomanticHelper.security.services.HelperJobServiceImpl;
import com.fpt.edu.DomanticHelper.security.services.LocationEntityServiceImpl;
import com.fpt.edu.DomanticHelper.security.services.PostServiceImpl;
import com.fpt.edu.DomanticHelper.security.services.UserEntityServiceImpl;

public class HelperJobController {

	@Autowired
	private HelperJobServiceImpl helperJobService;
	
	@Autowired
	private UserEntityServiceImpl userEntityService;
	
	@Autowired
	private LocationEntityServiceImpl locationEntityService;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<HelperJob> getPostById(@PathVariable("id") int id) {
		HelperJob helper = helperJobService.findHelperById(id);
		return new ResponseEntity<>(helper, HttpStatus.OK);
	}
	
	@PostMapping("/addHelper/{id}")
	public ResponseEntity<HelperJob> addHelper(@PathVariable("id") int id, @RequestBody HelperJob theHelperJob) {
		User oldUser = userEntityService.findUserById(id);
		if (oldUser != null) {
			
			HelperJob helperJob = new HelperJob(id, id, null, null, null, null, null, null,
					null, null, null, id, null, id, null, null, oldUser);
			
			helperJobService.save(helperJob);
			return new ResponseEntity<>(helperJob, HttpStatus.OK);
		}
		return null;
	}
}
