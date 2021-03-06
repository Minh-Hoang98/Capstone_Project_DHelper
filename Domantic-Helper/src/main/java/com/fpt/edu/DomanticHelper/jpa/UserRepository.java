package com.fpt.edu.DomanticHelper.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpt.edu.DomanticHelper.entity.User;

import com.fpt.edu.DomanticHelper.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserEntityById(int id);

    Optional<User> findUserEntityByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    Boolean existsByPhone(String phone);
    
    @Query("SELECT c FROM User c WHERE c.email = ?1")
    public User findByEmail(String email); 
     
    public User findByResetPasswordToken(String token);
}
