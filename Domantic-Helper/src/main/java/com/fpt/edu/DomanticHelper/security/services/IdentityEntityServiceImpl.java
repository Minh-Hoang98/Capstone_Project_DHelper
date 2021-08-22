package com.fpt.edu.DomanticHelper.security.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fpt.edu.DomanticHelper.entity.Identity;
import com.fpt.edu.DomanticHelper.entity.Location;
import com.fpt.edu.DomanticHelper.entity.User;
import com.fpt.edu.DomanticHelper.jpa.IdentityRepository;

@Service
@Transactional
public class IdentityEntityServiceImpl {


    private static ArrayList<Identity> identities = new ArrayList<Identity>();

    static {
        // identities.add(new IdentityEntity(1,"image","Vũ", "Minh","Giáo Sư","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","445", new Date(),new LocationEntity()));
        // identities.add(new IdentityEntity(2,"image","Hoàng", "Minh","Phụ Hồ","Nam",new Date(),"Việt Nam", "Không", "Hà Tĩnh","123", new Date(),new LocationEntity()));
    }

    @Autowired
    private IdentityRepository identityRepository;

    public List<Identity> findAll() {
        return identityRepository.findAll();
    }

    public Identity findById(int theId) {
        Optional<Identity> result = identityRepository.findById(theId);

        Identity theIdentity = null;

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

    public Identity add(Identity theIdentity) {
    	theIdentity.setIdIdentity(0);
        return identityRepository.save(theIdentity);
    }
    
    public void save(Identity theIdentity) {
        identityRepository.save(theIdentity);
    }
    
    public Identity updateIdentity(Identity identity) {   	
        return identityRepository.save(identity);
    }
    

}
