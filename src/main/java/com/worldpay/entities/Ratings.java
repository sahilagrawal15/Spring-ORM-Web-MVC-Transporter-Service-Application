package com.worldpay.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Ratings {
	
	@Id
	@GeneratedValue(generator="system-increment")
	@GenericGenerator(name="system-increment",strategy="increment")
	private int rid;
	private int rating;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Transporter transporter;
	@ManyToOne
	private Deals deals;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Transporter getTransporter() {
		return transporter;
	}
	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}
	public Deals getDeals() {
		return deals;
	}
	public void setDeals(Deals deals) {
		this.deals = deals;
	}
	@Override
	public String toString() {
		return "Ratings [rid=" + rid + ", rating=" + rating + "]";
	}

	
	
}
