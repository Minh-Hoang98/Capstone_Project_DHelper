package com.fpt.edu.DomanticHelper.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.edu.DomanticHelper.entity.Identity;

public interface IdentityRepository extends JpaRepository<Identity, Integer> {

}
