package com.worldpay.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worldpay.entities.City;
import com.worldpay.entities.Customer;

@Repository
public class CustomerDaoImplementation implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Customer addData(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(customer);
		tr.commit();
		session.close();
		return customer;
	}

	public Customer verifyCustomer(Customer customer) {

		Session session = sessionFactory.openSession();
		Customer customer1 = session.get(Customer.class, customer.getUsername());
		return customer1;

	}

	public List<Customer> viewAll() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		List<Customer> students = cr.list();
		session.close();
		return students;
	}

	public Customer update(String username) {
		Session session = sessionFactory.openSession();
		String hql = "from Customer where username=:username";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		return (Customer) query.getSingleResult();
	}

	public Customer updateData(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(customer);
		tr.commit();
		session.close();
		return customer;
	}

	public List<String> getCities() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select cityname from City");
		return query.list();
	}

	public void addCity(String city) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(new City(city));
		tr.commit();
		session.close();

	}

	public List getAllCustomerEmail() {
		Session session = sessionFactory.openSession();
		String SQL = "select username from Customer";
		Query query = session.createQuery(SQL);
		return query.list();
	}

}
