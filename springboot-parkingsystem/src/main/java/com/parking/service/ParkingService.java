package com.parking.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.parking.entity.Vehicles;
import com.parking.parkingenum.ParkingSpot;
import com.parking.repository.ParkingRepository;

public class ParkingService {

	@Autowired
	private ParkingRepository parkingRepository;

	public Vehicles parkVechile(Vehicles vechile) {

		return parkingRepository.save(vechile);
	}

	public Optional<Vehicles> getVehicle(Long slot) {
		Optional<Vehicles> vehicle = parkingRepository.findById(slot);
		if (!vehicle.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehicle is not found in the parking area");
		}

		return vehicle;

	}

	public void deleteVehicle(Long slot) {
		Optional<Vehicles> vehicle = parkingRepository.findById(slot);
		if (!vehicle.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehicle is not found in the parking area");
		}

		parkingRepository.deleteById(slot);

	}

	public void getAvailability(Long slot) {

		Optional<Vehicles> optionalVehicle = parkingRepository.findById(slot);
		Vehicles vehicle = optionalVehicle.get();
		if (vehicle.getParkingSpot() != ParkingSpot.Occupied) {
			System.out.println("The parking Space is empty");
		}

		System.out.println("The parking space is occupied");

	}

	public int calculateParkingPrice(Long slot)
	{
		Optional<Vehicles> optionalVehicle = parkingRepository.findById(slot);
		if (!optionalVehicle.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehicle is not found in the parking area");
		}
		Vehicles vehicle = optionalVehicle.get();
		Timestamp parkingTime = vehicle.getTime();
         int hours = parkingTime.getHours();
		int days = hours/24;
        int price = 30*days;
        int remainingHours = hours % 24;
        price += Math.min(remainingHours, 3) * 3 + Math.max(remainingHours - 3, 0) * 1;
        return price;     	
		
	}

	public void checkparkingSpaceAvailable() {
		List<Vehicles> vehicle = parkingRepository.findAll();
		if (vehicle.contains(ParkingSpot.Empty)) {
			System.out.println("The parking space is available ");
		}

	}

}
