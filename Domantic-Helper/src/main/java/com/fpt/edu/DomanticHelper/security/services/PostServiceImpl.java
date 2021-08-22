package com.fpt.edu.DomanticHelper.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.entity.Post;
import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import com.fpt.edu.DomanticHelper.jpa.PostReponsitory;

@Service
@Transactional
public class PostServiceImpl {

	@Autowired
    private PostReponsitory postRepository;
	
	 public Post findPostyId(Long id) {
	        return postRepository.findById(id)
	                .orElseThrow(() -> new UserNotFoundException("Post by id " + id + " was not found"));
	    }

	 public Post save(Post thePost) {
		return postRepository.save(thePost);
	 }
}
