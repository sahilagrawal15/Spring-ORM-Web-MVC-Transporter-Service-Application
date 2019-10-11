package com.worldpay.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.dao.CustomerDao;
import com.worldpay.entities.City;
import com.worldpay.entities.Customer;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	JavaMailSender mailSender;

	public Customer addData(Customer customer) {
		Customer customer1 = customerDao.addData(customer);
		return customer1;
	}

	public Customer verifyCustomer(Customer customer) {
		Customer customer1 = customerDao.verifyCustomer(customer);
		return customer1;
	}

	public List<Customer> viewAll() {

		List<Customer> list = new ArrayList<Customer>();
		list = customerDao.viewAll();

		return list;
	}

	public Customer updateCustomer(String username) {
		Customer customer1 = new Customer();
		customer1 = customerDao.update(username);
		return customer1;
	}

	public Customer updateData(Customer customer) {
		Customer customer1 = new Customer();
		customer1 = customerDao.updateData(customer);
		return customer1;
	}
	public void sendMail(Customer customer) {
		//try
	//	{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(customer.getUsername());
		mailMessage.setSubject("Welcome to Transporter Portal");
		mailMessage.setText("Hey There!");
		mailSender.send(mailMessage);
		/*}
		catch(Exception e){
			e.printStackTrace();
		}
		*/

	}

	public List<String> getCities() {
		List<String> list = customerDao.getCities();
		return list;
	}

	public void addCity(String city) {
		customerDao.addCity(city);
	}

}
