package com.worldpay.entities;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Vehicle {
	
	@Id 
	@GeneratedValue(generator="system-increment")
	@GenericGenerator(name="system-increment",strategy="increment")
	private int id;
//	@NotNull(message="This Field is mandatory") 
//	@Size(min=2, max=10, message="Enter 2 - 10 characters.")
	private String vehicleType;
//	@NotNull(message="This Field is mandatory") 
//	@Size(min=2, max=10, message="Your name should be between 2 - 10 characters.")
	private String model;
//	@NotNull(message="This Field is mandatory") 
//	@Size(min=2, max=10, message="Your name should be between 2 - 10 characters.")
	private String color;
	private String manYear;
	private int capacity;
	private Blob pictures;
	private Blob documents;
	private Blob fitnessCertificate;
	@ManyToOne
	private Transporter transporter;
	@OneToOne(mappedBy="vehicle",cascade=CascadeType.ALL)
	private Deals deals;
	private boolean approval;

	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getManYear() {
		return manYear;
	}
	public void setManYear(String manYear) {
		this.manYear = manYear;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Blob getPictures() {
		return pictures;
	}
	public void setPictures(Blob pictures) {
		this.pictures = pictures;
	}
	public Blob getDocuments() {
		return documents;
	}
	public void setDocuments(Blob documents) {
		this.documents = documents;
	}
	public Blob getFitnessCertificate() {
		return fitnessCertificate;
	}
	public void setFitnessCertificate(Blob fitnessCertificate) {
		this.fitnessCertificate = fitnessCertificate;
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
	public Vehicle(int id, String vehicleType, String model, String color, String manYear, int capacity, Blob pictures,
			Blob documents, Blob fitnessCertificate, Transporter transporter, Deals deals) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
		this.model = model;
		this.color = color;
		this.manYear = manYear;
		this.capacity = capacity;
		this.pictures = pictures;
		this.documents = documents;
		this.fitnessCertificate = fitnessCertificate;
		this.transporter = transporter;
		this.deals = deals;
	}
	public Vehicle() {
		super();
	}
	public Vehicle(int id) {
		super();
		this.id = id;
	}
	public boolean isApproval() {
		return approval;
	}
	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleType=" + vehicleType + ", model=" + model + ", color=" + color
				+ ", manYear=" + manYear + ", capacity=" + capacity + ", pictures=" + pictures + ", documents="
				+ documents + ", fitnessCertificate=" + fitnessCertificate + ", approval=" + approval + "]";
	}
	
	
	
}
