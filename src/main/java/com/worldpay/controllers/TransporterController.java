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

import com.worldpay.entities.Customer;
import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;
import com.worldpay.services.CustomerService;
import com.worldpay.services.TransporterService;

@Controller
public class TransporterController {

	@Autowired
	private TransporterService transporterService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping("addTransporter")
	public ModelAndView dispData() {
		Transporter transporter = new Transporter();
		try{
		List<String> citydata = customerService.getCities();
		ModelAndView modelAndView = new ModelAndView("insertTransporter");
		modelAndView.addObject("transporter", transporter);
		modelAndView.addObject("citydata", citydata);
		return modelAndView;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("logout");
	}

	@RequestMapping("searchTransporter")
	public ModelAndView searchData(HttpServletRequest request) {
		if (request.getSession().getAttribute("admins") != null) {
			Transporter transporter = new Transporter();
			ModelAndView modelAndView = new ModelAndView("searchTransporterResult");
			modelAndView.addObject("transporter", transporter);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}
	}

	@RequestMapping("saveTransporter")
	public ModelAndView saveCustomerData(@Valid @ModelAttribute("transporter") Transporter transporter,
			@RequestParam("photo1") MultipartFile file1, @RequestParam("photo2") MultipartFile file2,
			@RequestParam("photo3") MultipartFile file3,
			BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("redirect:addTransporter");
			return mv;
		} else {
			try {
				// For image uploading
				byte b[] = file1.getBytes();
				Blob blob = BlobProxy.generateProxy(b);
				transporter.setPhoto(blob);

				// For documents
				byte idbytes[] = file2.getBytes();
				Blob idblob = BlobProxy.generateProxy(idbytes);
				transporter.setDocument(idblob);
				
				// For documents
				byte idbytes2[] = file3.getBytes();
				Blob idblob2 = BlobProxy.generateProxy(idbytes2);
				transporter.setDocument(idblob2);

			} catch (IOException e) {

				e.printStackTrace();
			}
			Transporter transporter1 = transporterService.addData(transporter);
			ModelAndView modelAndView = new ModelAndView("insertedTransporterRecord");
			modelAndView.addObject("display", transporter1);
			return modelAndView;
		}
	}

	@RequestMapping("searchTransporter2")
	public ModelAndView showSearchResult(@RequestParam("tusername") String tusername) {
		Transporter transporter = transporterService.searchTransporter(tusername);
		ModelAndView mv = new ModelAndView("searchedTransporterResult");
		mv.addObject("transporter", transporter);
		return mv;
	}

	@RequestMapping("LoadImage")
	public void readImage(@RequestParam("tusername") String tusername, HttpServletResponse response) {
		Transporter transporter = transporterService.searchTransporter(tusername);
		Blob blob = transporter.getPhoto();
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

	@RequestMapping("LoadDocument")
	public void readIdentity(@RequestParam("tusername") String tusername, HttpServletResponse response) {
		response.setContentType("application/pdf");
		Transporter transporter = transporterService.searchTransporter(tusername);
		Blob blob = transporter.getDocument();
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

	@RequestMapping("LoadDocument2")
	public void readIdentity2(@RequestParam("tusername") String tusername, HttpServletResponse response) {
		response.setContentType("application/pdf");
		Transporter transporter = transporterService.searchTransporter(tusername);
		Blob blob = transporter.getDocument();
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

	@RequestMapping("viewAllTransporter")
	public ModelAndView viewAllTrEntry(@ModelAttribute("view") Transporter transporter) {
		List<Transporter> trans = transporterService.viewAll();
		ModelAndView mv = new ModelAndView("showAllTransporter");
		mv.addObject("trans", trans);
		return mv;

	}

	@RequestMapping("approveTransporter")
	public ModelAndView approval(@ModelAttribute("transporter") Transporter transporter,
			@RequestParam("code") String tusername) {
		transporter = transporterService.updateTransporter(tusername);
		System.out.println(transporter);
		System.out.println(tusername);
		transporterService.approveData(tusername);
		transporterService.sendMail2(transporter);

		ModelAndView modelAndView = new ModelAndView("redirect:viewAllTransporter");
		return modelAndView;
	}

	@RequestMapping("updateTrans")
	public ModelAndView updateTransporters(@ModelAttribute("transporter") Transporter transporter,
			@SessionAttribute("transporters") String transporters, HttpServletRequest request) {
		if(request.getSession().getAttribute("transporters")!=null){
		Transporter transporter1 = new Transporter();
		List<String> citydata = customerService.getCities();
		transporter1 = transporterService.updateTransporter(transporters);
		System.out.println(transporter1);
		ModelAndView modelAndView = new ModelAndView("updateTransporter");
		modelAndView.addObject("transporter", transporter1);
		modelAndView.addObject("citydata", citydata);
		return modelAndView;
		}
		else
		{
			ModelAndView mv=new ModelAndView("logout");
			return mv;
		}
	}

	@RequestMapping("updateTransporterSave")
	public ModelAndView updatedTransporter(@Valid @ModelAttribute("transporter") Transporter transporter,
			@SessionAttribute("transporters") String transporters, @RequestParam("photo1") MultipartFile file1,
			@RequestParam("photo2") MultipartFile file2,  @RequestParam("photo3") MultipartFile file3, BindingResult result) {
		if (result.hasErrors()) {

			ModelAndView mv = new ModelAndView("redirect:updateTrans");
			return mv;
		} else {
			try {
				// For image uploading
				byte b[] = file1.getBytes();
				Blob blob = BlobProxy.generateProxy(b);
				transporter.setPhoto(blob);

				// For documents
				byte idbytes[] = file2.getBytes();
				Blob idblob = BlobProxy.generateProxy(idbytes);
				transporter.setDocument(idblob);
				
				// For documents
				byte idbytes2[] = file3.getBytes();
				Blob idblob2 = BlobProxy.generateProxy(idbytes2);
				transporter.setDocument(idblob2);

			} catch (IOException e) {

				e.printStackTrace();
			}
			transporter = transporterService.updateData(transporter);
			ModelAndView mv = new ModelAndView("updatedTransporterRecord");
			return mv;
		}
	}

	@RequestMapping("deleteTransporter")
	public ModelAndView deleteEntry2(@ModelAttribute("view") Transporter transporter) {
		List<Transporter> trans = transporterService.viewAll();
		transporter = transporterService.searchTransporter(transporter.getTusername());
		transporterService.deleteTransporter(transporter.getTusername());
		transporterService.sendMail3(transporter);
		ModelAndView mv = new ModelAndView("redirect:viewAllTransporter");
		mv.addObject("delete", transporter);
		mv.addObject("studList", trans);
		return mv;
	}

	@RequestMapping("viewAllQueries")
	public ModelAndView viewQueries() {
		ModelAndView mv = new ModelAndView("viewTransporterQueries");
		return mv;
	}

}
