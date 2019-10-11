package com.worldpay.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.entities.City;
import com.worldpay.entities.Customer;
import com.worldpay.entities.Deals;
import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;
import com.worldpay.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("addCustomer")
	public ModelAndView dispData() {
		Customer customer = new Customer();
		List<String> citydata = customerService.getCities();
		ModelAndView modelAndView = new ModelAndView("insertCustomer");
		modelAndView.addObject("citydata", citydata);
		modelAndView.addObject("customer", customer);
		return modelAndView;
	}

	@RequestMapping("saveCustomer")
	public ModelAndView showEntry(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<String> citydata = customerService.getCities();
			ModelAndView modelAndView = new ModelAndView("redirect:addCustomer");
			modelAndView.addObject("citydata", citydata);

			return modelAndView;

		} else {
			customer = customerService.addData(customer);
			customer.getUsername();
			customerService.sendMail(customer);
			ModelAndView modelAndView = new ModelAndView("insertedCustomerRecord");
			modelAndView.addObject("display", customer);
			return modelAndView;
		}
	}

	@RequestMapping("viewAllCustomer")
	public ModelAndView viewAllEntry(@ModelAttribute("view") Customer customer, HttpServletRequest request) {
		if (request.getSession().getAttribute("admins") != null) {
			List<Customer> cust = customerService.viewAll();
			ModelAndView mv = new ModelAndView("showAllCustomer");
			mv.addObject("cust", cust);
			return mv;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}

	}

	@RequestMapping("updateCust")
	public ModelAndView updateCustomers(@ModelAttribute("customer") Customer customer,
			@SessionAttribute("customers") String customers, HttpServletRequest request) {

		if (request.getSession().getAttribute("customers") != null) {
			Customer customer1 = new Customer();
			List<String> citydata = customerService.getCities();
			customer1 = customerService.updateCustomer(customers);
			System.out.println(customer1);
			ModelAndView modelAndView = new ModelAndView("updateCustomer");
			modelAndView.addObject("customer", customer1);
			modelAndView.addObject("citydata", citydata);

			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}
	}

	@RequestMapping("updateSaveCustomer")
	public ModelAndView updatedCustomer(@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> citydata = customerService.getCities();
			ModelAndView modelAndView = new ModelAndView("redirct:updateCust");
			modelAndView.addObject("citydata", citydata);
			return modelAndView;
		} else {
			customer = customerService.updateData(customer);
			ModelAndView mv = new ModelAndView("updatedCustomerRecord");
			return mv;
		}
	}

	@RequestMapping("ViewDeals")
	public ModelAndView viewAllDeal() {

		ModelAndView modelAndView = new ModelAndView("showAllDeals");
		return modelAndView;
	}

	@RequestMapping("addACity")
	public ModelAndView addCities(@ModelAttribute("city") City city, HttpServletRequest request) {
		if (request.getSession().getAttribute("admins") != null) {
			List<String> citylist = customerService.getCities();
			ModelAndView mv = new ModelAndView("insertCity");
			mv.addObject("city", city);
			mv.addObject("citylist", citylist);
			return mv;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}

	}

	@RequestMapping("saveCity")
	public ModelAndView saveCity(@ModelAttribute("city") City city) {

		customerService.addCity(city.getCityname());
		List<String> citylist = customerService.getCities();
		ModelAndView mv = new ModelAndView("redirect:addACity");
		mv.addObject("citylist", citylist);
		return mv;
	}

}
