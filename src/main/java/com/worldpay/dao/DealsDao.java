package com.worldpay.dao;

import java.sql.Date;
import java.util.List;

import com.worldpay.entities.Deals;
import com.worldpay.entities.Vehicle;

public interface DealsDao {
	
	public Deals addData(Deals deals);
	public Deals searchDeals2(int dealno);
	public void deleteDeals(int dealno);
	public List<Deals> viewAll();
	public void approve(int dealno);
	public Deals updateData(Deals deals);
	public Deals update(int dealno);
	public List getVehicleIdByTransporter(String tusername);
	public List selectStartCityFromDeals();
	public List selectEndCityFromDeals();
	public List selectStartDateFromDeals();
	public List<Deals> getFilterOnDeals(String start,String end,String date, int price);
}
