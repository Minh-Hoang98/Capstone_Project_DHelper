package com.fpt.edu.DomanticHelper.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.edu.DomanticHelper.entity.Location;
import com.fpt.edu.DomanticHelper.entity.Post;

public interface PostReponsitory extends JpaRepository<Post, Long> {

	Post getPostById(Long idPost);
}
