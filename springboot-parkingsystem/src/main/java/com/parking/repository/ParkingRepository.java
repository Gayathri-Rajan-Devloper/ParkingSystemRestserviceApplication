package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.entity.Vehicles;

@Repository
public interface ParkingRepository extends JpaRepository<Vehicles, Long> {

	
	
	
	
}
