package com.fpt.edu.DomanticHelper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fpt.edu.DomanticHelper.entity.Location;
import com.fpt.edu.DomanticHelper.security.services.LocationEntityServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/location")
public class LocationEntityController {

    @Autowired
    private LocationEntityServiceImpl locationEntityService;

//	// expose "/user" and return list of user
//	@GetMapping("/locations")
//	public List<LocationEntity> findAllLocation() {
//		return locationEntityService.findAll();
//	}
//
//	// add mapping for GET /user/{userId}
//	
//	@GetMapping("/locations/{locationId}")
//	public LocationEntity getLocation(@PathVariable int locationId) {
//		
//		LocationEntity theLocation = locationEntityService.findById(locationId);
//		
//		if (theLocation == null) {
//			throw new RuntimeException("User id not found - " + locationId);
//		}
//		
//		return theLocation;
//	}
//	
//	// add mapping for POST /user - add new user
//	
//	@PostMapping("/locations")
//	public LocationEntity addLocation(@RequestBody LocationEntity theLocation) {
//		
//		theLocation.setIdLocation(0);
//		locationEntityService.save(theLocation);
//		
//		return theLocation;
//	}
//	
//	// add mapping for PUT /users - update existing users
//	
//	@PutMapping("/locations/{locationId}")
//	public LocationEntity updateLocation(@RequestBody LocationEntity theLocation) {
//
//		locationEntityService.save(theLocation);
//		
//		return theLocation;
//	}

    @GetMapping("/all")
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> locations = locationEntityService.findAllLocation();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") Long id) {
        Location employee = locationEntityService.findLocationById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        Location newLocation = locationEntityService.addLocationEntity(location);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
        Location updateLocation = locationEntityService.updateLocation(location);
        return new ResponseEntity<>(updateLocation, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
//        employeeService.deleteEmployee(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
