package com.worldpay.services;

import java.util.List;

import com.worldpay.entities.Ratings;

public interface RatingsService {
	public Ratings addData(int rating,String username,String tusername,int dealcode);
	public String selectAverageRatings(String tusername);

	


}
