package com.fpt.edu.DomanticHelper.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.edu.DomanticHelper.entity.UserEntity;

public interface UserEntityReponsitory extends JpaRepository<UserEntity, String>{

}
