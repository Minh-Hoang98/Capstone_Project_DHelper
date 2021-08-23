package com.fpt.edu.DomanticHelper.controller;

import static com.fpt.edu.DomanticHelper.ObjectHelper.Common.covertLocation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.edu.DomanticHelper.entity.Location;
import com.fpt.edu.DomanticHelper.entity.Post;
import com.fpt.edu.DomanticHelper.entity.User;
import com.fpt.edu.DomanticHelper.security.jwt.FindJobRequest;
import com.fpt.edu.DomanticHelper.security.services.LocationEntityServiceImpl;
import com.fpt.edu.DomanticHelper.security.services.PostServiceImpl;
import com.fpt.edu.DomanticHelper.security.services.UserEntityServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostServiceImpl postService;
	
	@Autowired
	private UserEntityServiceImpl userEntityService;
	
	@Autowired
	private LocationEntityServiceImpl locationEntityService;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
		Post post = postService.findPostyId(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@PostMapping("/addPostChuNha/{id}")
	public ResponseEntity<Post> addPostChuNha(@PathVariable("id") int id, @RequestBody FindJobRequest postRequest) {
		User oldUser = userEntityService.findUserById(id);
		if (oldUser != null) {
			
			Location newAddress = covertLocation(postRequest.getAddress());			
			locationEntityService.addLocationEntity(newAddress);
            
			Post newPost = new Post(postRequest.getTitle(), postRequest.getContent(),Float.valueOf(postRequest.getSalary()), postRequest.getDateStart(),
					postRequest.getStatus(), newAddress, oldUser, 1);
			
			postService.save(newPost);
			return new ResponseEntity<>(newPost, HttpStatus.OK);
		}
		return null;
	}
	
	@PostMapping("/addPostGiupViec/{id}")
	public ResponseEntity<Post> addPostGiupViec(@PathVariable("id") int id, @RequestBody FindJobRequest postRequest) {
		User oldUser = userEntityService.findUserById(id);
		if (oldUser != null) {
			
			Location newAddress = covertLocation(postRequest.getAddress());			
			locationEntityService.addLocationEntity(newAddress);
            
			Post newPost = new Post(postRequest.getTitle(), postRequest.getContent(),Float.valueOf(postRequest.getSalary()), postRequest.getDateStart(),
					postRequest.getStatus(), newAddress, oldUser, 2);
			
			postService.save(newPost);
			return new ResponseEntity<>(newPost, HttpStatus.OK);
		}
		return null;
	}
}
