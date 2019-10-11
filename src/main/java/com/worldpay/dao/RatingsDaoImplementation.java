package com.worldpay.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Deals;
import com.worldpay.entities.Ratings;
import com.worldpay.entities.Transporter;

@Repository
public class RatingsDaoImplementation implements RatingsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Ratings addData(int rating, String username, String tusername, int dealcode) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Customer c = session.get(Customer.class, username);
		Transporter t = session.get(Transporter.class, tusername);
		Deals d = session.get(Deals.class, dealcode);
		Ratings ratings = new Ratings();
		ratings.setCustomer(c);
		ratings.setTransporter(t);
		ratings.setDeals(d);
		ratings.setRating(rating);
		session.save(ratings);
		tr.commit();
		session.close();
		return ratings;
	}

	public String selectAverageRatings(String tusername) {
		Session session = sessionFactory.openSession();

		String SQL = "select avg(rating),transporter_tusername from ratings GROUP BY transporter_tusername having transporter_tusername=:tusername";
		Query query = session.createSQLQuery(SQL);
		query.setParameter("tusername", tusername);
		List<Object[]> list1 = query.list();
		Object ar[] = list1.get(0);
		System.out.println(ar[0]);

		return "" + ar[0];

	}
}
