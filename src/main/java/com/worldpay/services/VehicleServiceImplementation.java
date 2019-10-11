package com.worldpay.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.worldpay.dao.VehicleDao;
import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;

@Service
public class VehicleServiceImplementation implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	public Vehicle addData(Vehicle vehicle) {
		Vehicle vehicle1 = vehicleDao.addData(vehicle);
		return vehicle1;
	}

	public Vehicle searchVehicle(int id) {
		Vehicle vehicle = vehicleDao.searchVehicle(id);
		return vehicle;
	}

	public List<Vehicle> viewAll() {

		List<Vehicle> list = new ArrayList<Vehicle>();
		list = vehicleDao.viewAll();

		return list;
	}

	public Vehicle searchVehicle2(int id) {

		Vehicle vehicle = vehicleDao.searchVehicle2(id);
		return vehicle;

	}

	public void deleteVehicle(int id) {

		vehicleDao.deleteVehicle(id);

	}

	public void approveData(int id) {

		vehicleDao.approve(id);
	}

	public List<Vehicle> getVehicleIdByTransporter(String tusername) {
		List<Vehicle> list = vehicleDao.getVehicleIdByTransporter(tusername);
		return list;
	}

	/*
	 * public void sendMail2(Vehicle vehicle) { SimpleMailMessage
	 * mailMessage=new SimpleMailMessage();
	 * mailMessage.setTo(transporter.getTusername());
	 * mailMessage.setSubject("Approval Successfull"); mailMessage.
	 * setText("Hey There!, You can now access the features of this website....Login Now"
	 * ); mailSender.send(mailMessage);
	 * 
	 * }
	 */
}
