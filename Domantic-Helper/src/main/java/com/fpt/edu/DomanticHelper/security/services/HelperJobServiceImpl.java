package com.fpt.edu.DomanticHelper.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.entity.HelperJob;
import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import com.fpt.edu.DomanticHelper.jpa.HelperRepository;

@Service
@Transactional
public class HelperJobServiceImpl {

	@Autowired
	private HelperRepository helperRepository;

	public HelperJob findHelperById(int id) {
		return helperRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("HelperJob by id " + id + " was not found"));
	}

	public HelperJob save(HelperJob helperJob) {
		return helperRepository.save(helperJob);
	}
}
