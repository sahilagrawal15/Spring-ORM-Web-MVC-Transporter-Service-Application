package com.worldpay.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class QueryClass {
	
	@Id 
	@GeneratedValue(generator="system-increment")
	@GenericGenerator(name="system-increment",strategy="increment")
	private int qid;
	private String customerrequest;
	private String transporterresponse;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Transporter transporter;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getCustomerrequest() {
		return customerrequest;
	}
	public void setCustomerrequest(String customerrequest) {
		this.customerrequest = customerrequest;
	}
	public String getTransporterresponse() {
		return transporterresponse;
	}
	public void setTransporterresponse(String transporterresponse) {
		this.transporterresponse = transporterresponse;
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
	
	public QueryClass(int qid) {
		super();
		this.qid = qid;
	}
	public QueryClass() {
		super();
	}
	@Override
	public String toString() {
		return "Query [qid=" + qid + ", customerrequest=" + customerrequest + ", transporterresponse="
				+ transporterresponse + "]";
	}

	
	
}
