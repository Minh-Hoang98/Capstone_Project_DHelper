package com.fpt.edu.DomanticHelper.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fpt.edu.DomanticHelper.entity.IdentityEntity;
import com.fpt.edu.DomanticHelper.entity.LocationEntity;
import com.fpt.edu.DomanticHelper.jpa.IdentityEntityReponsitory;

@Service
public class IdentityEntityServiceImpl implements IdentityEntityService {
	
	
	private static ArrayList<IdentityEntity> identities =  new ArrayList<IdentityEntity>();

	static {
		// identities.add(new IdentityEntity(1,"image","Vũ", "Minh","Giáo Sư","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","445", new Date(),new LocationEntity()));
		// identities.add(new IdentityEntity(2,"image","Hoàng", "Minh","Phụ Hồ","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","123", new Date(),new LocationEntity()));
	}

	@Autowired
	private IdentityEntityReponsitory identityEntityReponsitory;

	@Override
	public List<IdentityEntity> findAll() {
		return identityEntityReponsitory.findAll();
	}

	@Override
	public IdentityEntity findById(int theId) {
		Optional<IdentityEntity> result = identityEntityReponsitory.findById(theId);

		IdentityEntity theIdentity = null;

		if (result.isPresent()) {
			theIdentity = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find User id - " + theId);
		}

//		for(IdentityEntity identi: identities) {
//			if(identi.getIdIdentity() == theId) {
//				return identi;
//			}
//		}
		return theIdentity;
	}

	@Override
	public void save(IdentityEntity theUser) {
		identityEntityReponsitory.save(theUser);
	}

}
