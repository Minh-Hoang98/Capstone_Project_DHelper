package com.fpt.edu.DomanticHelper.security.services;


import java.util.List;

import javax.transaction.Transactional;

import com.fpt.edu.DomanticHelper.entity.*;
import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.jpa.UserRepository;

@Service
@Transactional
public class UserEntityServiceImpl {

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
    private UserRepository userRepository;
    

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUserById(int id) {
        return userRepository.findUserEntityById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public User updateUser(User user) {   	
        return userRepository.save(user);
    }

    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            userRepository.save(user);
        } else {
            throw new UserNotFoundException("Could not find any customer with the email " + email);
        }
    }

    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        user.setResetPasswordToken(null);
        userRepository.save(user);
    }
} 


