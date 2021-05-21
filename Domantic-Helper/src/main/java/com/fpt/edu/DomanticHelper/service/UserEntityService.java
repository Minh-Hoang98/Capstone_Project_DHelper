package com.fpt.edu.DomanticHelper.service;

import java.util.List;

import com.fpt.edu.DomanticHelper.entity.UserEntity;

public interface UserEntityService {

	public List<UserEntity> findAll();

	public UserEntity findById(String theId);

	public void save(UserEntity theUser);

	public void deleteById(String theId);
}