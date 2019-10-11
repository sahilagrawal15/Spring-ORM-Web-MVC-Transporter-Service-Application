package com.worldpay.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Deals {

	@Id
	@GeneratedValue(generator="system-increment")
	@GenericGenerator(name="system-increment",strategy="increment")
	private int dealno;
	private Date startdate;
	private Date enddate;
	private String startcity;
	private String endcity;
	@ManyToOne
	private Transporter transporter;
	@OneToOne
	private Vehicle vehicle;
	private boolean approval;
	private int price;
	@OneToMany(mappedBy="deals",cascade=CascadeType.ALL)
	private List<Ratings> ratings;
	public int getDealno() {
		return dealno;
	}
	public void setDealno(int dealno) {
		this.dealno = dealno;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getStartcity() {
		return startcity;
	}
	public void setStartcity(String startcity) {
		this.startcity = startcity;
	}
	public String getEndcity() {
		return endcity;
	}
	public void setEndcity(String endcity) {
		this.endcity = endcity;
	}
	public Transporter getTransporter() {
		return transporter;
	}
	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Deals(int dealno, Date startdate, Date enddate, String startcity, String endcity, Transporter transporter,
			Vehicle vehicle) {
		super();
		this.dealno = dealno;
		this.startdate = startdate;
		this.enddate = enddate;
		this.startcity = startcity;
		this.endcity = endcity;
		this.transporter = transporter;
		this.vehicle = vehicle;
	}
	public Deals() {
		super();
	}
	public Deals(int dealno) {
		super();
		this.dealno = dealno;
	}
	public boolean isApproval() {
		return approval;
	}
	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	@Override
	public String toString() {
		return "Deals [dealno=" + dealno + ", startdate=" + startdate + ", enddate=" + enddate + ", startcity="
				+ startcity + ", endcity=" + endcity + ", approval=" + approval + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Ratings> getRatings() {
		return ratings;
	}
	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}
	
	
	
}
