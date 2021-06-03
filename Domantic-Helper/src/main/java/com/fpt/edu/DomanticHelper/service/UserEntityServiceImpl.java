package com.fpt.edu.DomanticHelper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import com.fpt.edu.DomanticHelper.entity.Employee;
import com.fpt.edu.DomanticHelper.entity.HelperJob;
=======
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
import com.fpt.edu.DomanticHelper.entity.IdentityEntity;
import com.fpt.edu.DomanticHelper.entity.LocationEntity;
import com.fpt.edu.DomanticHelper.entity.UserEntity;
import com.fpt.edu.DomanticHelper.jpa.UserEntityReponsitory;

@Service
public class UserEntityServiceImpl implements UserEntityService {
	
	private static ArrayList<UserEntity> users =  new ArrayList<UserEntity>();
	
	private static ArrayList<IdentityEntity> identities =  new ArrayList<IdentityEntity>();
	
<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	static {
<<<<<<< HEAD
		identities.add(new IdentityEntity(1,"image","Vũ", "Minh","Giáo Sư","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","445", new Date(), new LocationEntity()));
		users.add(new UserEntity(1,"image", "MrCss", "123", "0938442112", "hoang003pro@gmail.com","Yeu em","1", new LocationEntity(), new IdentityEntity(1,"image","Hoàng", "Minh","MrCss","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","234", new Date(), new LocationEntity())));
		users.add(new UserEntity(2, "image","ANH", "12555", "09384423332", "hoang005pro@gmail.com","Yeu anh","1", new LocationEntity(), new IdentityEntity()));
=======
		identities.add(new IdentityEntity(2,"image","Vũ", "Minh","Giáo Sư","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","445", new Date(), new LocationEntity()));
		users.add(new UserEntity(1,"image", "MrCss", "123", "0938442112", "hoang003pro@gmail.com","Yeu em", new LocationEntity(1L,"Việt Nam","Gia Lai","IaGrai","IaHrung","Thôn",1), new IdentityEntity(1,"image","Hoàng", "Minh","MrCss","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","234", new Date(), new LocationEntity(1L,"Việt Nam","Gia Lai","IaGrai","IaHrung","Thôn",1))));
		users.add(new UserEntity(2, "image","ANH", "12555", "09384423332", "hoang005pro@gmail.com","Yeu anh", new LocationEntity(), new IdentityEntity()));
>>>>>>> branch 'master' of https://github.com/Minh-Hoang98/Capstone_Project_DHelper.git
	}

	@Autowired
	private UserEntityReponsitory userEntityReponsitory;

	@Override
	public List<UserEntity> findAll() {
		return users;
	}

	@Override
	public UserEntity findById(int theId) {
//		Optional<UserEntity> result = userEntityReponsitory.findById(theId);
//
//		UserEntity theUser = null;
//
//		if (result.isPresent()) {
//			theUser = result.get();
//		} else {
//			// we didn't find the employee
//			throw new RuntimeException("Did not find User id - " + theId);
//		}

		for(UserEntity user: users) {
			if(user.getId() == theId) {
				return user;
			}
		}
		return null;
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
