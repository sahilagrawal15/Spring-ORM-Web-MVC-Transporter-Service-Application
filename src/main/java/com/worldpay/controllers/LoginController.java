package com.worldpay.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Transporter;
import com.worldpay.services.CustomerService;
import com.worldpay.services.TransporterService;

@Controller
@SessionAttributes(names = { "transporters", "customers", "admins" })
public class LoginController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private TransporterService transporterService;

	@RequestMapping("customerPage")
	public ModelAndView cust() {

		ModelAndView mv = new ModelAndView("customer");
		return mv;

	}

	@RequestMapping("adminPage")
	public ModelAndView adm() {

		ModelAndView mv = new ModelAndView("admin");
		return mv;

	}

	@RequestMapping("transporterPage")
	public ModelAndView tran() {

		ModelAndView mv = new ModelAndView("transporter");
		return mv;

	}

	@RequestMapping("login")
	public ModelAndView signin() {

		ModelAndView modelAndView = new ModelAndView("loginPage");
		return modelAndView;
	}

	@RequestMapping("loginSave")
	public ModelAndView saveLogin(@RequestParam("username") String username,
			@RequestParam("passwords") String passwords, @RequestParam("loginType") String loginType,
			HttpServletRequest request) {

		if (loginType.equalsIgnoreCase("admin")) {
			if (username.equals("sahil") && passwords.equals("12345")) {
				ModelAndView modelAndView = new ModelAndView("admin");
				HttpSession session = request.getSession();
				session.setAttribute("admins", username);
				return modelAndView;

			}
		} else if (loginType.equalsIgnoreCase("transporter"))

		{

			Transporter transporter = new Transporter();
			transporter.setTusername(username);
			transporter.setPasswords(passwords);
			Transporter transporter1 = transporterService.verifyTransporter(transporter);
			if (transporter1 != null && transporter1.getPasswords().equals(passwords)
					&& transporter1.getApproval() == true) {
				ModelAndView modelAndView = new ModelAndView("transporter");
				modelAndView.addObject("transporters", username);
				return modelAndView;
			} else {
				return new ModelAndView("logout");
			}
		} else if (loginType.equalsIgnoreCase("customer")) {
			Customer customer = new Customer();
			customer.setUsername(username);
			customer.setPasswords(passwords);
			Customer customer1 = customerService.verifyCustomer(customer);
			if (customer1 != null && customer1.getPasswords().equals(passwords)) {
				ModelAndView modelAndView = new ModelAndView("customer");
				modelAndView.addObject("customers", username);

				return modelAndView;
			} else
				return new ModelAndView("logout");

		}

		return new ModelAndView("logout");

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, SessionStatus session) {
		session.setComplete();
		request.getSession().invalidate();
		return "redirect:/login";
	}

}
