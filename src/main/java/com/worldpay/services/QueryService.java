package com.worldpay.services;

import java.util.List;

import com.worldpay.entities.QueryClass;

public interface QueryService {
	
	public List<QueryClass> getTransporterUsernameFromQuery(String tusername);
	public QueryClass addData(String queryasked,String username,String tusername);
	public List<QueryClass> viewAll();
	public QueryClass addDataForResponse(String queryresponse,String qid,String tusername);
	public List<QueryClass> viewAllResponse();
	public List<QueryClass> getCustomerUsernameFromQuery(String username);
}
