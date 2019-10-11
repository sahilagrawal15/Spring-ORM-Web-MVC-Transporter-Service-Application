package com.worldpay.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Deals;
import com.worldpay.entities.QueryClass;
import com.worldpay.entities.Transporter;

@Repository
public class QueryDaoImplementation implements QueryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<QueryClass> getCustomerUsernameFromQuery(String username) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Customer c = session.get(Customer.class, username);
		List<QueryClass> list1 = c.getQuery();
		return list1;
	}

	public List<QueryClass> getTransporterUsernameFromQuery(String tusername) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Transporter t = session.get(Transporter.class, tusername);
		List<QueryClass> list2 = t.getQuery();
		return list2;

	}

	public QueryClass addData(String queryasked, String username, String tusername) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Customer c = session.get(Customer.class, username);
		Transporter t = session.get(Transporter.class, tusername);
		QueryClass query = new QueryClass();
		query.setCustomer(c);
		query.setTransporter(t);
		query.setCustomerrequest(queryasked);
		query.setTransporterresponse("");
		session.save(query);
		tr.commit();
		session.close();
		return query;
	}

	public List<QueryClass> viewAll() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(QueryClass.class);
		List<QueryClass> list = cr.list();
		session.close();
		return list;
	}

	public List<QueryClass> viewAllResponse() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(QueryClass.class);
		List<QueryClass> list2 = cr.list();
		session.close();
		return list2;
	}

	public QueryClass addDataForResponse(String queryresponse, String qid, String tusername) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Transporter t = session.get(Transporter.class, tusername);
		Customer c = session.get(Customer.class, qid);
		QueryClass query = new QueryClass();
		query.setTransporter(t);
		query.setCustomer(c);
		query.setCustomerrequest("");
		query.setTransporterresponse(queryresponse);
		session.save(query);
		tr.commit();
		session.close();
		return query;
	}
	
	

}
