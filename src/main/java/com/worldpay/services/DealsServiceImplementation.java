package com.worldpay.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.worldpay.dao.CustomerDao;
import com.worldpay.dao.DealsDao;
import com.worldpay.entities.Customer;
import com.worldpay.entities.Deals;
import com.worldpay.entities.Vehicle;

@Service
public class DealsServiceImplementation implements DealsService {

	@Autowired
	private DealsDao dealsDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	JavaMailSender mailSender;

	public Deals addData(Deals deals) {
		Deals deals1 = dealsDao.addData(deals);
		return deals1;
	}

	public Deals searchDeals2(int dealno) {

		Deals deals = dealsDao.searchDeals2(dealno);
		return deals;

	}

	public void deleteDeals(int dealno) {

		dealsDao.deleteDeals(dealno);

	}

	public List<Deals> viewAll() {

		List<Deals> list = new ArrayList<Deals>();
		list = dealsDao.viewAll();

		return list;
	}

	public void approveData(int dealno) {

		dealsDao.approve(dealno);
	}

	public Deals updateDealsShowData(int dealno) {
		Deals deals1 = new Deals();
		deals1 = dealsDao.update(dealno);
		return deals1;
	}

	public Deals updateData(Deals deals) {
		Deals deals1 = new Deals();
		deals1 = dealsDao.updateData(deals);
		return deals1;
	}

	public List getVehicleIdByTransporter(String tusername) {
		List<Vehicle> list = dealsDao.getVehicleIdByTransporter(tusername);
		return list;
	}

	public List selectStartCityFromDeals() {
		List<String> list = dealsDao.selectStartCityFromDeals();
		return list;
	}

	public List selectEndCityFromDeals() {
		List<String> list = dealsDao.selectEndCityFromDeals();
		return list;
	}

	public List selectStartDateFromDeals() {
		List<String> list = dealsDao.selectStartDateFromDeals();
		return list;
	}

	public void sendMailForDealPosting() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		List<String> allemail = customerDao.getAllCustomerEmail();
		Object[] objarr = allemail.toArray();
		String[] allEmailArr = Arrays.copyOf(objarr, objarr.length, String[].class);
		mailMessage.setTo(allEmailArr);
		mailMessage.setSubject("A New Deal is Posted");
		mailMessage.setText("Hey There!..A new exciting deal has been posted....Hurry to grab the deal right away!!!!");
		mailSender.send(mailMessage);

	}

	public List<Deals> getFilterOnDeals(String start, String end, String date, int price) {
		List<Deals> deal1 = dealsDao.getFilterOnDeals(start, end, date, price);
		return deal1;
	}

}
