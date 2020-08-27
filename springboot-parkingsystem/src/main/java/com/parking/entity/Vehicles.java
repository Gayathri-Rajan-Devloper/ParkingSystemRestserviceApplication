package com.parking.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.parking.parkingenum.ParkingSpot;

@Entity
@Table
public class Vehicles {

	@Id
	@GeneratedValue
	private Long slot;
	private String vehiclesName;
	private String vehiclesColor;
	private String vehiclesNumber;
	 private Timestamp time ;
	@Enumerated(EnumType.STRING)
	private ParkingSpot parkingSpot;
	
	public Vehicles(Long slot, String vehiclesName, String vehiclesColor, String vehiclesNumber, Timestamp time,
			ParkingSpot parkingSpot) {
		super();
		this.slot = slot;
		this.vehiclesName = vehiclesName;
		this.vehiclesColor = vehiclesColor;
		this.vehiclesNumber = vehiclesNumber;
		this.time = time;
		this.parkingSpot = parkingSpot;
	}

	public Long getSlot() {
		return slot;
	}

	public void setSlot(Long slot) {
		this.slot = slot;
	}

	public String getVehiclesName() {
		return vehiclesName;
	}

	public void setVehiclesName(String vehiclesName) {
		this.vehiclesName = vehiclesName;
	}

	public String getVehiclesColor() {
		return vehiclesColor;
	}

	public void setVehiclesColor(String vehiclesColor) {
		this.vehiclesColor = vehiclesColor;
	}

	public String getVehiclesNumber() {
		return vehiclesNumber;
	}

	public void setVehiclesNumber(String vehiclesNumber) {
		this.vehiclesNumber = vehiclesNumber;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	@Override
	public String toString() {
		return "Vehicles [slot=" + slot + ", vehiclesName=" + vehiclesName + ", vehiclesColor=" + vehiclesColor
				+ ", vehiclesNumber=" + vehiclesNumber + ", time=" + time + ", parkingSpot=" + parkingSpot + "]";
	}
	

    
}
