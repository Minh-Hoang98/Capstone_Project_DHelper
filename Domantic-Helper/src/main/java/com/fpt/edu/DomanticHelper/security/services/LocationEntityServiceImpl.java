package com.fpt.edu.DomanticHelper.security.services;

import java.util.List;

import javax.transaction.Transactional;

import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.edu.DomanticHelper.entity.Location;
import com.fpt.edu.DomanticHelper.jpa.LocationRepository;


@Service
@Transactional
public class LocationEntityServiceImpl {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAllLocation() {
        return locationRepository.findAll();
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

    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location findLocationById(Long id) {
        return locationRepository.findLocationById(id)
                .orElseThrow(() -> new UserNotFoundException("Location by id " + id + " was not found"));
    }

    public Location addLocationEntity(Location locationEntity) {
        locationEntity.setIdLocation(0L);
        return locationRepository.save(locationEntity);
    }


}
