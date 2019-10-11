package com.worldpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldpay.dao.RatingsDao;
import com.worldpay.entities.Ratings;

@Service
public class RatingsServiceImplementation implements RatingsService {

	@Autowired
	private RatingsDao ratingsDao;

	public Ratings addData(int rating, String username, String tusername, int dealcode) {

		Ratings ratings = ratingsDao.addData(rating, username, tusername, dealcode);
		return ratings;

	}

	public String selectAverageRatings(String tusername) {
		String s = ratingsDao.selectAverageRatings(tusername);
		return s;

	}

}
