package com.worldpay.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;

@Repository
public class TransporterDaoImplementation implements TransporterDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Transporter addData(Transporter transporter) {
		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		transporter.setApproval(false);
		session.save(transporter);
		transaction.commit();
		session.close();
		return transporter;
	}

	public Transporter searchTransporter(String tusername) {
		Session session = sessionFactory.openSession();
		Transporter transporter = session.get(Transporter.class, tusername);
		session.close();
		return transporter;
	}

	public Transporter verifyTransporter(Transporter transporter) {

		Session session = sessionFactory.openSession();
		Transporter transporter1 = session.get(Transporter.class, transporter.getTusername());
		return transporter1;
	}

	public List<Transporter> viewAll() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Transporter.class);
		List<Transporter> transporters = cr.list();
		session.close();
		return transporters;
	}

	public void approve(String username) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String SQL = "update Transporter SET approval=:approve where tusername=:username";
		Query query = session.createQuery(SQL);
		query.setParameter("approve", true);
		query.setParameter("username", username);
		query.executeUpdate();
		transaction.commit();
		session.close();

	}

	public Transporter update(String tusername) {
		Session session = sessionFactory.openSession();
		String hql = "from Transporter where tusername=:tusername";
		Query query = session.createQuery(hql);
		query.setParameter("tusername", tusername);
		return (Transporter) query.getSingleResult();
	}

	public Transporter updateData(Transporter transporter) {
		Session session = sessionFactory.openSession();
		transporter.setApproval(true);
		Transaction tr = session.beginTransaction();
		session.update(transporter);
		tr.commit();
		session.close();
		return transporter;
	}

	public void deleteTransporter(String tusername) {

		Session session = sessionFactory.openSession();
		Transporter transporter = session.get(Transporter.class, tusername);
		Transaction tr = session.beginTransaction();
		session.delete(transporter);
		tr.commit();
		session.close();

	}

}
