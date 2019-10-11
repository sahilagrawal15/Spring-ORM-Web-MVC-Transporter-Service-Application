package com.worldpay.entities;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Transporter {
	
//	@Email(message="Enter a valid Email address")
	@Id
	private String tusername;
	private String passwords;
	
//	@NotNull(message="Last Name can't be blank") 
//	@Size(min=5, max=30, message="Address should contain between 5 - 30 characters.")
	private String address;
	private String city;
	
//	@Pattern(regexp="[a-zA-z]+",message="Only Alphabets Allowed")
	private String state;
//	 @Pattern(regexp="[0-9]+", message="Only Numbers are allowed!") 
	private int phone;
	private int experience;
	private Blob photo;
	private Blob document;
	private Blob aadhar;
	private Boolean approval;
	@OneToMany(mappedBy="transporter",cascade=CascadeType.ALL)
	List<Vehicle> vehicle;
	@OneToMany(mappedBy="transporter",cascade=CascadeType.ALL)
	List<Deals> deals;
	@OneToMany(mappedBy="transporter",cascade=CascadeType.ALL)
	private List<QueryClass> query;
	@OneToMany(mappedBy="transporter",cascade=CascadeType.ALL)
	private List<Ratings> ratings;

	
	public String getTusername() {
		return tusername;
	}
	public void setTusername(String tusername) {
		this.tusername = tusername;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public Blob getDocument() {
		return document;
	}
	public void setDocument(Blob document) {
		this.document = document;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public Blob getAadhar() {
		return aadhar;
	}
	public void setAadhar(Blob aadhar) {
		this.aadhar = aadhar;
	}
	public Boolean getApproval() {
		return approval;
	}
	public void setApproval(Boolean approval) {
		this.approval = approval;
	}
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public Transporter(String tusername, String passwords, String address, String city, String state, int phone,
			int experience, Blob photo, Blob document, Blob aadhar, Boolean approval, List<Vehicle> vehicle) {
		super();
		this.tusername = tusername;
		this.passwords = passwords;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.experience = experience;
		this.photo = photo;
		this.document = document;
		this.aadhar = aadhar;
		this.approval = approval;
		this.vehicle = vehicle;
	}
	public Transporter(String tusername) {
		super();
		this.tusername = tusername;
	}
	public Transporter() {
		super();
	}
	public List<Deals> getDeals() {
		return deals;
	}
	public void setDeals(List<Deals> deals) {
		this.deals = deals;
	}
	@Override
	public String toString() {
		return "Transporter [tusername=" + tusername + ", passwords=" + passwords + ", address=" + address + ", city="
				+ city + ", state=" + state + ", phone=" + phone + ", experience=" + experience + ", photo=" + photo
				+ ", document=" + document + ", aadhar=" + aadhar + ", approval=" + approval + ", query=" + query + "]";
	}
	public List<QueryClass> getQuery() {
		return query;
	}
	public void setQuery(List<QueryClass> query) {
		this.query = query;
	}
	public List<Ratings> getRatings() {
		return ratings;
	}
	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}
	
	
	

}
