package com.worldpay.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.entities.Deals;
import com.worldpay.entities.Ratings;
import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;
import com.worldpay.services.DealsService;
import com.worldpay.services.RatingsService;

@Controller
public class RatingsController {

	@Autowired
	private DealsService dealsService;

	@Autowired
	private RatingsService ratingsService;

	@RequestMapping("Rate")
	public ModelAndView ratepage(HttpServletRequest request) {
		if (request.getSession().getAttribute("customers") != null) {
			Transporter transporter = new Transporter();
			Vehicle vehicle = new Vehicle();
			List<Deals> veh = dealsService.viewAll();
			ModelAndView mv = new ModelAndView("showAllDealsForRatings");
			mv.addObject("transporter", transporter);
			mv.addObject("vehicle", vehicle);
			mv.addObject("veh", veh);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("logout");
			return mv;
		}

	}

	@RequestMapping("giveRatings")
	public ModelAndView addRatings(@RequestParam("tusername") String tusername, @RequestParam("dealcode") int dealcode,
			@SessionAttribute("customers") String customers, HttpServletRequest request) {
		if (request.getSession().getAttribute("customers") != null) {
			ModelAndView mv = new ModelAndView("insertRatings");
			mv.addObject("dealcode", dealcode);
			mv.addObject("customers", customers);
			mv.addObject("tusername", tusername);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("logout");
			return mv;
		}

	}

	@RequestMapping("saveRatings")
	public ModelAndView saveTheRatings(@RequestParam("ratingpoints") int ratingpoints,
			@RequestParam("tusername") String tusername, @RequestParam("dealcode") int dealcode,
			@SessionAttribute("customers") String customers) {

		Ratings ratings = ratingsService.addData(ratingpoints, customers, tusername, dealcode);
		ModelAndView mv = new ModelAndView("redirect:Rate");
		mv.addObject("ratings", ratings);
		return mv;
	}

	@RequestMapping("showAvgRatings")
	public ModelAndView showRatings(@RequestParam("tusername") String tusername) {
		String rating = ratingsService.selectAverageRatings(tusername);
		ModelAndView mv = new ModelAndView("showRatings");
		mv.addObject("rating", rating);
		return mv;
	}

}
