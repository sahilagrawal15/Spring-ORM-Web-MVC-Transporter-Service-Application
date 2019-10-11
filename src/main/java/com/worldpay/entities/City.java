package com.worldpay.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class City {
	
	@Id
	@GeneratedValue(generator="system-increment")
	@GenericGenerator(name="system-increment",strategy="increment")
	private int cid;
	private String cityname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	@Override
	public String toString() {
		return "City [cid=" + cid + ", city=" + cityname + "]";
	}
	public City(String cityname) {
		super();
		this.cityname = cityname;
		
		
	}
	public City() {
		super();
	}
	

}
