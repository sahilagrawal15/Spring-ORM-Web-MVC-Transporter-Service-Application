package com.worldpay.services;

import java.util.List;

import com.worldpay.entities.City;
import com.worldpay.entities.Customer;

public interface CustomerService {
	public Customer addData(Customer customer);
	public Customer verifyCustomer(Customer customer);
	public List<Customer> viewAll();
	public Customer updateCustomer(String username);
	public Customer updateData(Customer customer);
	public void sendMail(Customer customer);
	public List<String> getCities();
	public void addCity(String city);
	
}
