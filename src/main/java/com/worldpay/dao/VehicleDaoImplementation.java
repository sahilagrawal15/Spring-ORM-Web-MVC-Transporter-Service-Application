package com.worldpay.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worldpay.entities.Transporter;
import com.worldpay.entities.Vehicle;

@Repository
public class VehicleDaoImplementation implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Vehicle addData(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		vehicle.setApproval(false);
		session.save(vehicle);
		tr.commit();
		session.close();
		return vehicle;
	}

	public Vehicle searchVehicle(int id) {
		Session session = sessionFactory.openSession();
		Vehicle vehicle = session.get(Vehicle.class, id);
		session.close();
		return vehicle;
	}

	public List<Vehicle> viewAll() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vehicle.class);
		List<Vehicle> vehicles = cr.list();
		session.close();
		return vehicles;
	}

	public Vehicle searchVehicle2(int id) {
		Session session = sessionFactory.openSession();
		Vehicle vehicle = session.get(Vehicle.class, id);
		session.close();
		return vehicle;
	}

	public void deleteVehicle(int id) {

		Session session = sessionFactory.openSession();
		Vehicle vehicle = session.get(Vehicle.class, id);
		Transaction tr = session.beginTransaction();

		session.delete(vehicle);
		tr.commit();

		session.close();

	}

	public void approve(int id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String SQL = "update Vehicle SET approval=:approve where id=:id1";
		Query query = session.createQuery(SQL);
		query.setParameter("approve", true);
		query.setParameter("id1", id);
		query.executeUpdate();
		transaction.commit();
		session.close();

	}

	public List<Vehicle> getVehicleIdByTransporter(String tusername) {
		Session session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Transporter transporter = session.get(Transporter.class,tusername);
		List<Vehicle> list = transporter.getVehicle();
		return list;
	}
}
