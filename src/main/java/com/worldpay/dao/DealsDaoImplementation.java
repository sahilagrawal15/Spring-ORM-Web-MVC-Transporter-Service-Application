package com.worldpay.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Deals;
import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;

@Repository
public class DealsDaoImplementation implements DealsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Deals addData(Deals deals) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		deals.setApproval(false);
		session.save(deals);
		tr.commit();
		session.close();
		return deals;
	}

	public Deals searchDeals2(int dealno) {
		Session session = sessionFactory.openSession();
		Deals deals = session.get(Deals.class, dealno);
		session.close();
		return deals;
	}

	public void deleteDeals(int dealno) {
		Session session = sessionFactory.openSession();
		Deals deals = session.get(Deals.class, dealno);
		Transaction tr = session.beginTransaction();

		session.delete(deals);
		tr.commit();

		session.close();

	}

	public List<Deals> viewAll() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Deals.class);
		List<Deals> deals = cr.list();
		session.close();
		return deals;
	}

	public void approve(int dealno) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String SQL = "update Deals SET approval=:approve where dealno=:id1";
		Query query = session.createQuery(SQL);
		query.setParameter("approve", true);
		query.setParameter("id1", dealno);
		query.executeUpdate();
		transaction.commit();
		session.close();

	}

	public Deals update(int dealno) {
		Session session = sessionFactory.openSession();
		String hql = "from Deals where dealno=:dealno";
		Query query = session.createQuery(hql);
		query.setParameter("dealno", dealno);
		return (Deals) query.getSingleResult();
	}

	public Deals updateData(Deals deals) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(deals);
		tr.commit();
		session.close();
		return deals;
	}

	public List getVehicleIdByTransporter(String tusername) {
		Session session = sessionFactory.openSession();
		Transporter transporter = session.get(Transporter.class, tusername);
		List<Vehicle> list = transporter.getVehicle();
		return list;

	}

	public List selectStartCityFromDeals() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Deals.class);
		Projection projection = Projections.property("startcity");
		criteria.setProjection(projection);
		List list = criteria.list();
		return list;
	}

	public List selectEndCityFromDeals() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Deals.class);
		Projection projection = Projections.property("endcity");
		criteria.setProjection(projection);
		List list = criteria.list();
		return list;
	}

	public List selectStartDateFromDeals() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Deals.class);
		Projection projection = Projections.property("startdate");
		criteria.setProjection(projection);
		List list = criteria.list();
		return list;
	}

	public List<Deals> getFilterOnDeals(String start, String end, String date, int price) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Deals.class);
		criteria.add(Restrictions.eq("startcity", start));
		criteria.add(Restrictions.eq("endcity", end));
		criteria.add(Restrictions.eq("startdate", date));

		if (price != 0)
			criteria.addOrder(Order.asc("price"));
		return criteria.list();
	}

}
