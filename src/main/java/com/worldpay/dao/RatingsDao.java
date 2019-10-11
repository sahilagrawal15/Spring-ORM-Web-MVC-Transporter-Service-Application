package com.worldpay.dao;

import java.util.List;

import com.worldpay.entities.Ratings;

public interface RatingsDao {

	public Ratings addData(int rating,String username,String tusername,int dealcode);
	public String selectAverageRatings(String tusername);
}
