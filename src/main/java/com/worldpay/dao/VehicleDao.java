package com.worldpay.dao;

import java.util.List;

import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;

public interface VehicleDao {

	public Vehicle addData(Vehicle vehicle);
	public Vehicle searchVehicle(int id);
	public List<Vehicle> viewAll();
	public Vehicle searchVehicle2(int id);
	public void deleteVehicle(int id);
	public void approve(int id);
	public List<Vehicle> getVehicleIdByTransporter(String tusername);

}
