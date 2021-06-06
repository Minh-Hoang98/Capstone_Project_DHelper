package com.fpt.edu.DomanticHelper.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.edu.DomanticHelper.entity.LocationEntity;

@Repository
public interface LocationEntityReponsitory extends JpaRepository<LocationEntity, Long>{

	Optional<LocationEntity> findLocationById(Long id);

}
