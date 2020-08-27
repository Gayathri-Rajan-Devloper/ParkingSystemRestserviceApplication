package com.parking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.entity.Vehicles;
import com.parking.service.ParkingService;

@RestController
public class ParkingController {

	@Autowired
	private ParkingService parkingService;

	@PostMapping("/park")
	public Vehicles parkVechile(@RequestBody Vehicles vechile) {

		return parkingService.parkVechile(vechile);

	}

	@GetMapping("/park/{slot}")
	public Optional<Vehicles> getVechile(@PathVariable("slot") Long slot) {
		return parkingService.getVehicle(slot);
	}

	@DeleteMapping("/unpark/{slot}")
	public void unparkVehicles(@PathVariable("slot") Long slot) {
		parkingService.deleteVehicle(slot);
	}

	@GetMapping("/parkspace/{slot}")
	public void getAvailability(@PathVariable("slot") Long slot) {
		parkingService.getAvailability(slot);
	}

	@GetMapping("/park/price/{slot}")
	public int getParkingCharges(@PathVariable("slot") Long slot) {
		return parkingService.calculateParkingPrice(slot);
	}

	@GetMapping("/park")
	public void checkparkingSpaceAvailable() {

		parkingService.checkparkingSpaceAvailable();
	}
}
