package com.fpt.edu.DomanticHelper.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.entity.LocationEntity;
import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import com.fpt.edu.DomanticHelper.jpa.LocationEntityReponsitory;


@Service
@Transactional
public class LocationEntityServiceImpl{

	@Autowired
	private LocationEntityReponsitory locationEntityReponsitory;

	public List<LocationEntity> findAllLocation() {
		return locationEntityReponsitory.findAll();
	}

//	public LocationEntity findById(Long theId) {
//		Optional<LocationEntity> result = locationEntityReponsitory.findById(theId);
//
//		LocationEntity theLocation = null;
//
//		if (result.isPresent()) {
//			theLocation = result.get();
//		} else {
//			throw new RuntimeException("Did not find Location id - " + theId);
//		}
//		return theLocation;
//	}
	
	public LocationEntity updateLocation(LocationEntity location) {
        return locationEntityReponsitory.save(location);
    }
	
	public LocationEntity findLocationById(Long id) {
        return locationEntityReponsitory.findLocationById(id)
                .orElseThrow(() -> new UserNotFoundException("Location by id " + id + " was not found"));
    }
	
	public LocationEntity addLocationEntity(LocationEntity locationEntity) {
		locationEntity.setIdLocation(0L);
        return locationEntityReponsitory.save(locationEntity);
    }


}
