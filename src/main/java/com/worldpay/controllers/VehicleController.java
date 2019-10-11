package com.worldpay.controllers;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;
import com.worldpay.services.VehicleService;

@Controller
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping("addVehicle")
	public ModelAndView dispVehicleData(HttpServletRequest request) {
		if (request.getSession().getAttribute("transporters") != null) {
			Vehicle vehicle = new Vehicle();
			ModelAndView modelAndView = new ModelAndView("insertVehicle");
			modelAndView.addObject("vehicle", vehicle);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}
	}

	@RequestMapping("deleteVehicles")
	public ModelAndView deleteVehicleData() {
		Vehicle vehicle = new Vehicle();
		ModelAndView modelAndView = new ModelAndView("deleteVehicleRecord");
		modelAndView.addObject("vehicle", vehicle);
		return modelAndView;
	}

	@RequestMapping("saveVehicle")
	public ModelAndView saveVehicleData(@ModelAttribute("vehicle") Vehicle vehicle,
			@SessionAttribute("transporters") String username, @RequestParam("doc1") MultipartFile file4,
			@RequestParam("doc2") MultipartFile file5, @RequestParam("doc3") MultipartFile file6
			) {

		
		

			try {
				// For image uploading
				byte b[] = file4.getBytes();
				Blob blob = BlobProxy.generateProxy(b);
				vehicle.setPictures(blob);

				// For documents
				byte idbytes1[] = file5.getBytes();
				Blob idblob1 = BlobProxy.generateProxy(idbytes1);
				vehicle.setFitnessCertificate(idblob1);

				byte idbytes2[] = file6.getBytes();
				Blob idblob2 = BlobProxy.generateProxy(idbytes2);
				vehicle.setDocuments(idblob2);

			} catch (IOException e) {

				e.printStackTrace();
			}
			vehicle.setTransporter(new Transporter(username));
			Vehicle vehicle1 = vehicleService.addData(vehicle);
			ModelAndView modelAndView = new ModelAndView("insertedVehicleRecord");
			modelAndView.addObject("display1", vehicle1);
			return modelAndView;
		
	}

	@RequestMapping("LoadImages")
	public void readImage(@RequestParam("id") int id, HttpServletResponse response) {
		Vehicle vehicle = vehicleService.searchVehicle(id);
		Blob blob = vehicle.getPictures();
		byte b[] = null;
		try {
			b = blob.getBytes(1, (int) blob.length());
			ServletOutputStream out = response.getOutputStream();
			out.write(b);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("LoadDocuments")
	public void readIdentity(@RequestParam("id") int id, HttpServletResponse response) {
		response.setContentType("application/pdf");
		Vehicle vehicle = vehicleService.searchVehicle(id);
		Blob blob = vehicle.getDocuments();
		byte b[] = null;
		try {
			b = blob.getBytes(1, (int) blob.length());
			ServletOutputStream out = response.getOutputStream();
			out.write(b);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("LoadDocuments2")
	public void readIdentity2(@RequestParam("id") int id, HttpServletResponse response) {
		response.setContentType("application/pdf");
		Vehicle vehicle = vehicleService.searchVehicle(id);
		Blob blob = vehicle.getFitnessCertificate();
		byte b[] = null;
		try {
			b = blob.getBytes(1, (int) blob.length());
			ServletOutputStream out = response.getOutputStream();
			out.write(b);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("viewAllVehicle")
	public ModelAndView viewAllVehEntry(@ModelAttribute("view") Vehicle vehicle, HttpServletRequest request) {
		if (request.getSession().getAttribute("admins") != null) {
			Transporter transporter = new Transporter();
			List<Vehicle> veh = vehicleService.viewAll();
			ModelAndView mv = new ModelAndView("showAllVehicle");
			mv.addObject("transporter", transporter);
			mv.addObject("veh", veh);
			return mv;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}

	}

	@RequestMapping("deleteVehicle")
	public ModelAndView deleteEntry3(@ModelAttribute("view") Vehicle vehicle) {
		List<Vehicle> veh = vehicleService.viewAll();
		vehicle = vehicleService.searchVehicle2(vehicle.getId());
		vehicleService.deleteVehicle(vehicle.getId());
		ModelAndView mv = new ModelAndView("redirect:viewAllVehicle");
		mv.addObject("delete", vehicle);
		mv.addObject("studList", veh);
		return mv;
	}
	
	@RequestMapping("deleteVehicle2")
	public ModelAndView deleteEntry2(@ModelAttribute("view") Vehicle vehicle) {
		List<Vehicle> veh = vehicleService.viewAll();
		vehicle = vehicleService.searchVehicle2(vehicle.getId());
		vehicleService.deleteVehicle(vehicle.getId());
		ModelAndView mv = new ModelAndView("redirect:viewMyVehicles");
		mv.addObject("delete", vehicle);
		mv.addObject("studList", veh);
		return mv;
	}


	@RequestMapping("searchController")
	public ModelAndView searchEntry(@ModelAttribute("vehicle") Vehicle vehicle) {

		vehicle = vehicleService.searchVehicle2(vehicle.getId());
		ModelAndView mv = new ModelAndView("searchedVehicleRecord");
		mv.addObject("search", vehicle);
		return mv;
	}

	@RequestMapping("deleteController")
	public ModelAndView deleteEntry(@ModelAttribute("delete") Vehicle vehicle) {

		vehicle = vehicleService.searchVehicle2(vehicle.getId());
		vehicleService.deleteVehicle(vehicle.getId());
		ModelAndView mv = new ModelAndView("deletedVehicleRecord");
		mv.addObject("delete", vehicle);

		return mv;

	}

	@RequestMapping("approveVehicle")
	public ModelAndView approval(@ModelAttribute("vehicle") Vehicle vehicle, @RequestParam("id1") int id) {
		vehicleService.approveData(id);

		ModelAndView modelAndView = new ModelAndView("redirect:viewAllVehicle");
		return modelAndView;
	}
	
	@RequestMapping("viewMyVehicles")
	public ModelAndView viewAllMyVehicles(@SessionAttribute("transporters") String transporters){
		List<Vehicle> myvehiclelist=vehicleService.getVehicleIdByTransporter(transporters);
		ModelAndView mv=new ModelAndView("showMyVehicles");
		mv.addObject("transporters", transporters);
		mv.addObject("myvehiclelist", myvehiclelist);
		return mv;
	}

}
