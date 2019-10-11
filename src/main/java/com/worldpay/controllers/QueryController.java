package com.worldpay.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.entities.QueryClass;
import com.worldpay.entities.Transporter;
import com.worldpay.services.QueryService;

@Controller
public class QueryController {

	@Autowired
	private QueryService queryService;

	@RequestMapping("queryDeals")
	public ModelAndView addQuery(@RequestParam("tusername") String tusername,
			@SessionAttribute("customers") String customers, HttpServletRequest request) {

		if (request.getSession().getAttribute("customers") != null) {
			QueryClass query = new QueryClass();
			ModelAndView modelAndView = new ModelAndView("insertQuery");
			modelAndView.addObject("query", query);
			modelAndView.addObject("tusername", tusername);
			modelAndView.addObject("customers", customers);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}
	}

	@RequestMapping("saveQuery")
	public ModelAndView saveTheQuery(@RequestParam("queryasked") String queryasked,
			@RequestParam("tusername") String tusername, @SessionAttribute("customers") String customers,
			HttpServletRequest request) {

		if (request.getSession().getAttribute("customers") != null) {
			QueryClass query = queryService.addData(queryasked, customers, tusername);
			ModelAndView modelAndView = new ModelAndView("insertedQueryRecord");
			modelAndView.addObject("query", query);
			modelAndView.addObject("tusername", tusername);
			modelAndView.addObject("customers", customers);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("logout");
			return modelAndView;
		}
	}

	@RequestMapping("viewAllQuery")
	public ModelAndView viewQuery(@ModelAttribute("query") QueryClass query,
			@SessionAttribute("transporters") String transporters, HttpServletRequest request) {
		if (request.getSession().getAttribute("transporters") != null) {
			List<QueryClass> transporterlist = queryService.getTransporterUsernameFromQuery(transporters);
			ModelAndView mv = new ModelAndView("showAllQueries");
			mv.addObject("transporterlist", transporterlist);
			mv.addObject("transporters", transporters);
			mv.addObject("query", query);
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("logout");
			return mv;
		}

	}

	@RequestMapping("respondToQuery")
	public ModelAndView respondQuery(@SessionAttribute("transporters") String transporters,
			@RequestParam("qid") int qid) {
		QueryClass query = new QueryClass();
		ModelAndView mv = new ModelAndView("insertResponse");
		mv.addObject("transporters", transporters);
		mv.addObject("query", query);
		mv.addObject("qid", qid);
		return mv;

	}

	@RequestMapping("saveTrasnsporterResponse")
	public ModelAndView saveResponse(@RequestParam("responseGiven") String responseGiven,
			@RequestParam("username") String username, @SessionAttribute("transporters") String transporters) {

		QueryClass query2 = queryService.addDataForResponse(responseGiven, username, transporters);
		ModelAndView mv = new ModelAndView("insertedResponseRecord");
		mv.addObject("query2", query2);
		mv.addObject("responseGiven", responseGiven);
		mv.addObject("transporters", transporters);
		mv.addObject("username", username);
		return mv;

	}

	@RequestMapping("viewQueryResponses")
	public ModelAndView viewResponses(@ModelAttribute("query") QueryClass query,
			@SessionAttribute("customers") String customers) {

		List<QueryClass> list2 = queryService.getCustomerUsernameFromQuery(customers);
		System.out.println(list2);
		ModelAndView mv = new ModelAndView("showTransporterResponse");
		mv.addObject("query", query);
		mv.addObject("list2", list2);
		mv.addObject("customers", customers);

		return mv;
	}
	@RequestMapping("respondToQuery2")
	public ModelAndView respondQuery2(@SessionAttribute("transporters") String transporters,
			@RequestParam("qid") int qid,@RequestParam("username") String username) {
		QueryClass query = new QueryClass();
		ModelAndView mv = new ModelAndView("insertResponse");
		mv.addObject("transporters", transporters);
		mv.addObject("username", username);
		mv.addObject("query", query);
		mv.addObject("qid", qid);
		return mv;

	}
	


}