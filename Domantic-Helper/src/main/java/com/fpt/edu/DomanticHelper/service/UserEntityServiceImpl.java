package com.fpt.edu.DomanticHelper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.entity.UserEntity;
import com.fpt.edu.DomanticHelper.jpa.UserEntityReponsitory;

@Service
public class UserEntityServiceImpl implements UserEntityService {
	
	private static ArrayList<UserEntity> users =  new ArrayList<UserEntity>();
	
	static {
		users.add(new UserEntity(1, "MrCss", "123", "0938442112", "hoang003pro@gmail.com","Yeu em", 2, "Edu", new Date(), new Date(), "acd", "ass", 2, "123", "123", "123", "123", 2));
		users.add(new UserEntity(1, "ANH", "12555", "09384423332", "hoang005pro@gmail.com","Yeu anh", 2, "Edu", new Date(), new Date(), "acd", "ass", 2, "123", "123", "123", "123", 2));
	}

	@Autowired
	private UserEntityReponsitory userEntityReponsitory;

	@Override
	public List<UserEntity> findAll() {
		return users;
	}

	@Override
	public UserEntity findById(int theId) {
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
	public void deleteById(int theId) {
		userEntityReponsitory.deleteById(theId);
	}

}
