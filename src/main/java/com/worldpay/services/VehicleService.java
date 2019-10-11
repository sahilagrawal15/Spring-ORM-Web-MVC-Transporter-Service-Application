package com.worldpay.services;

import java.util.List;

import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;

public interface VehicleService {

	public Vehicle addData(Vehicle vehicle);
	public Vehicle searchVehicle(int id);
	public List<Vehicle> viewAll();
	public Vehicle searchVehicle2(int id);
	public void deleteVehicle(int id);
	public void approveData(int id);
	public List<Vehicle> getVehicleIdByTransporter(String tusername);



}
