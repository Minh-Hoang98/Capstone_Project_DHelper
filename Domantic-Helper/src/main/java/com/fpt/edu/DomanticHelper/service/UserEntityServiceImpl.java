package com.fpt.edu.DomanticHelper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fpt.edu.DomanticHelper.entity.UserEntity;
import com.fpt.edu.DomanticHelper.jpa.UserEntityReponsitory;

public class UserEntityServiceImpl implements UserEntityService {

	@Autowired
	private UserEntityReponsitory userEntityReponsitory;

	@Override
	public List<UserEntity> findAll() {
		return userEntityReponsitory.findAll();
	}

	@Override
	public UserEntity findById(String theId) {
		Optional<UserEntity> result = userEntityReponsitory.findById(theId);

		UserEntity theUser = null;

		if (result.isPresent()) {
			theUser = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find User id - " + theId);
		}

		return theUser;
	}

	@Override
	public void save(UserEntity theUser) {
		userEntityReponsitory.save(theUser);
	}

	@Override
	public void deleteById(String theId) {
		userEntityReponsitory.deleteById(theId);
	}

}
