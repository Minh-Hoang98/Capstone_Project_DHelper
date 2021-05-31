package com.fpt.edu.DomanticHelper.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.edu.DomanticHelper.entity.UserEntity;

@Repository
public interface UserEntityReponsitory extends JpaRepository<UserEntity, Long>{

}
