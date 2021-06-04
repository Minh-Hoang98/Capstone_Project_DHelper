package com.fpt.edu.DomanticHelper.service;

import java.util.List;

import com.fpt.edu.DomanticHelper.entity.IdentityEntity;

public interface IdentityEntityService {

	public List<IdentityEntity> findAll();

	public IdentityEntity findById(int theId);

	public void save(IdentityEntity theIndentity);

}
