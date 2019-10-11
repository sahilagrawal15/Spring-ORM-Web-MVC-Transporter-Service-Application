package com.worldpay.controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Deals;
import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;
import com.worldpay.services.CustomerService;
import com.worldpay.services.DealsService;

@Controller
public class DealsController {

	@Autowired
	private DealsService dealsService;

	@Autowired
	private CustomerService customerService;

	@RequestMapping("addDeals")
	public ModelAndView dispData(@SessionAttribute("transporters") String transporters, HttpServletRequest request) {
		if (request.getSession().getAttribute("transporters") != null) {
			Deals deals = new Deals();
			List<Vehicle> vehiclelist = dealsService.getVehicleIdByTransporter(transporters);
			List<String> citydata = customerService.getCities();
			ModelAndView modelAndView = new ModelAndView("insertDeals");
			modelAndView.addObject("vehiclelist", vehiclelist);
			modelAndView.addObject("deals", deals);
			modelAndView.addObject("citydata", citydata);
			return modelAndView;
		}

		else {
			ModelAndView mv = new ModelAndView("login");
			return mv;
		}
	}

	@RequestMapping("removeDeals")
	public ModelAndView removeData(HttpServletRequest request) {
		if (request.getSession().getAttribute("transporters") != null) {
			Deals deals = new Deals();
			ModelAndView modelAndView = new ModelAndView("deleteDeals");
			modelAndView.addObject("deals", deals);
			return modelAndView;
		} else {
			ModelAndView mv = new ModelAndView("logout");
			return mv;
		}
	}

	@RequestMapping("deleteTheDeal")
	public ModelAndView deleteEntry(@ModelAttribute("deals") Deals deals) {
		deals = dealsService.searchDeals2(deals.getDealno());
		dealsService.deleteDeals(deals.getDealno());
		ModelAndView mv = new ModelAndView("deletedDealsRecord");
		mv.addObject("delete", deals);
		return mv;

	}

	@RequestMapping("saveDeals")
	public ModelAndView showEntry(@Valid @ModelAttribute("deals") Deals deals,
			@ModelAttribute("vehicle") Vehicle vehicle, @SessionAttribute("transporters") String username,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("insertDeals");
			return modelAndView;

		} else {
			deals.setTransporter(new Transporter(username));
			deals = dealsService.addData(deals);
			dealsService.sendMailForDealPosting();
			ModelAndView modelAndView = new ModelAndView("insertedDealsRecord");
			modelAndView.addObject("display", deals);
			// modelAndView.addObject("display1", id1);
			return modelAndView;
		}
	}

	@RequestMapping("searchDeal")
	public ModelAndView searchEntry(@ModelAttribute("deals") Deals deals) {

		deals = dealsService.searchDeals2(deals.getDealno());
		ModelAndView mv = new ModelAndView("searchDeal");
		mv.addObject("search", deals);
		return mv;
	}

	@RequestMapping("viewAllDeals")
	public ModelAndView viewAllDealEntry(@ModelAttribute("view") Deals deals, HttpServletRequest request) {
		if (request.getSession().getAttribute("admins") != null) {
			Transporter transporter = new Transporter();
			Vehicle vehicle = new Vehicle();
			List<Deals> veh = dealsService.viewAll();
			ModelAndView mv = new ModelAndView("showAllDeals");
			mv.addObject("transporter", transporter);
			mv.addObject("vehicle", vehicle);
			mv.addObject("veh", veh);
			return mv;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}

	}

	@RequestMapping("deleteDeals")
	public ModelAndView deleteEntry3(@ModelAttribute("view") Deals deals) {
		List<Deals> deal = dealsService.viewAll();
		deals = dealsService.searchDeals2(deals.getDealno());
		dealsService.deleteDeals(deals.getDealno());
		ModelAndView mv = new ModelAndView("redirect:viewAllDeals");
		mv.addObject("delete", deals);
		mv.addObject("studList", deal);
		return mv;

	}

	@RequestMapping("approveDeals")
	public ModelAndView approval(@ModelAttribute("deals") Deals deals, @RequestParam("id1") int dealno) {
		dealsService.approveData(dealno);
		// vehicleService.sendMail2(vehicle);

		ModelAndView modelAndView = new ModelAndView("redirect:viewAllDeals");
		return modelAndView;
	}

	@RequestMapping("updateDealsPage")
	public ModelAndView updateDeal(@ModelAttribute("deals") Deals deals, @RequestParam("dealno") int dealno,
			HttpServletRequest request) {

		if (request.getSession().getAttribute("transporters") != null) {
			int dealno1 = deals.getDealno();
			deals = dealsService.updateDealsShowData(dealno1);
			System.out.println(deals);
			ModelAndView modelAndView = new ModelAndView("updateDealsPage");
			modelAndView.addObject("deals", deals);
			modelAndView.addObject("dealno", dealno);

			return modelAndView;
		} else {
			ModelAndView mv = new ModelAndView("logout");
			return mv;
		}
	}

	@RequestMapping("updateSaveDeals")
	public ModelAndView updatedCustomer(@ModelAttribute("deals") Deals deals, HttpServletRequest request) {
		if (request.getSession().getAttribute("transporters") != null) {
			deals = dealsService.updateData(deals);
			ModelAndView mv = new ModelAndView("updatedDealsRecord");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("logout");
			return mv;
		}
	}

	@RequestMapping("viewAllDealsForCustomers")
	public ModelAndView viewAllDealEntry2(@ModelAttribute("view") Deals deals, HttpServletRequest request) {
		if (request.getSession().getAttribute("customers") != null) {
			Transporter transporter = new Transporter();
			Vehicle vehicle = new Vehicle();
			List<Deals> veh = dealsService.viewAll();
			ModelAndView mv = new ModelAndView("showAllDealsForCustomer");
			mv.addObject("transporter", transporter);
			mv.addObject("vehicle", vehicle);
			mv.addObject("veh", veh);
			return mv;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}

	}

	@RequestMapping("viewDealsByFilters")
	public ModelAndView viewDealsFilters() {
		List<Deals> deallist = dealsService.viewAll();
		ModelAndView mv = new ModelAndView("showAllFilteredDeals");
		mv.addObject("deallist", deallist);
		List<String> citylist = customerService.getCities();
		mv.addObject("citylist", citylist);
		return mv;
	}

	@RequestMapping("filterDeals")
	public ModelAndView filterOnDeals(@RequestParam("startcity") String startcity,
			@RequestParam("endcity") String endcity, @RequestParam("startdate") String startdate,
			HttpServletRequest request) {

		int price1 = Integer.parseInt(request.getParameter(("price")));
		List<Deals> list = dealsService.getFilterOnDeals(startcity, endcity, startdate, price1);
		List<String> citylist = customerService.getCities();
		ModelAndView mv = new ModelAndView("viewDealsByFilters");
		mv.addObject("citylist", citylist);
		mv.addObject("list", list);
		return mv;

	}

}
