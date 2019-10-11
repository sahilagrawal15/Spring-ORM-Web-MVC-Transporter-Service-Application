package com.worldpay.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Customer {
	
	
	@Email(message="Enter a valid Email address")
	@Id
	private String username;
	
	@Pattern(regexp="[a-zA-z]+",message="Only Alphabets Allowed")
	@NotNull(message="First Name can't be blank") 
	@Size(min=2, max=10, message="Your name should be between 2 - 10 characters.")
	private String firstName;
	
	private String middleName;
	
	@Pattern(regexp="[a-zA-z]+",message="Only Alphabets Allowed")
	@NotNull(message="Last Name can't be blank") 
	@Size(min=2, max=10, message="Your name should be between 2 - 10 characters.")
	private String lastName;
	
	private String city;
	
	private String gender;
	
//	 @Pattern(regexp="[0-9]+", message="Invalid Age!") 
	private int mobile;
	 
//	 @Pattern(regexp="[0-9]+", message="Wrong PINCODE!")
	private int pincode;
	
	private String passwords;
	
	@NotNull(message="This field is mandatory")
	private String confirmPassword;
	
	@OneToMany(mappedBy="customer")
	private List<Ratings> ratings;
	
	@OneToMany(mappedBy="customer")
	private List<QueryClass> query;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/*public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}*/
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", city=" + city + ", gender=" + gender + ", mobile=" + mobile
				+ ", pincode=" + pincode + ", passwords=" + passwords + ", confirmPassword=" + confirmPassword + "]";
	}
	public List<QueryClass> getQuery() {
		return query;
	}
	public void setQuery(List<QueryClass> query) {
		this.query = query;
	}
	public Customer(String username) {
		super();
		this.username = username;
	}
	public Customer() {
		super();
	}
	public List<Ratings> getRatings() {
		return ratings;
	}
	public void setRatings(List<Ratings> ratings) {
		this.ratings = ratings;
	}
	
	
	
	
	

}
