package com.worldpay.dao;

import java.util.List;

import com.worldpay.entities.City;
import com.worldpay.entities.Customer;

public interface CustomerDao {
	
	public Customer addData(Customer customer);
	public Customer verifyCustomer(Customer customer);
	public List<Customer> viewAll();
	public Customer update(String username);
	public Customer updateData(Customer customer);
	public List<String> getCities();
	public void addCity(String city);
	public List getAllCustomerEmail();
	
}
