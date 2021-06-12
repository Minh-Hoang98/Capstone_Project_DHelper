package com.fpt.edu.DomanticHelper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.entity.Employee;
import com.fpt.edu.DomanticHelper.entity.HelperJob;

import com.fpt.edu.DomanticHelper.entity.IdentityEntity;
import com.fpt.edu.DomanticHelper.entity.LocationEntity;
import com.fpt.edu.DomanticHelper.entity.UserEntity;
import com.fpt.edu.DomanticHelper.jpa.UserEntityReponsitory;

@Service
@Transactional
public class UserEntityServiceImpl{
	
//	private static ArrayList<UserEntity> users =  new ArrayList<UserEntity>();
//
//	private static ArrayList<IdentityEntity> identities =  new ArrayList<IdentityEntity>();
//
//	static {
//		identities.add(new IdentityEntity(1,"image","Vũ", "Minh","Giáo Sư","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","445", new Date(),new LocationEntity()));
//		users.add(new UserEntity(1,"image", "MrCss", "123", "0938442112", "hoang003pro@gmail.com","Yeu em","1", new LocationEntity(), new IdentityEntity(1,"image","Hoàng", "Minh","MrCss","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","234", new Date(),new LocationEntity()),new Employee(),new HelperJob()));
//		users.add(new UserEntity(2, "image","ANH", "12555", "09384423332", "hoang005pro@gmail.com","Yeu anh","1", new LocationEntity(), new IdentityEntity()));
//
//	}

	@Autowired
	private UserEntityReponsitory userEntityReponsitory;

	public List<UserEntity> findAllUser() {
		return userEntityReponsitory.findAll();
	}

	public UserEntity findUserById(int id) {
		return userEntityReponsitory.findUserEntityById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}

	public UserEntity addUserEntity(UserEntity userEntity) {
		userEntity.setId(0);
		return userEntityReponsitory.save(userEntity);
	}

	public UserEntity updateUser(UserEntity user) {
		return userEntityReponsitory.save(user);
	}
}
