package com.worldpay.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldpay.dao.QueryDao;
import com.worldpay.entities.QueryClass;

@Service
public class QueryServiceImplementation implements QueryService {

	@Autowired
	private QueryDao queryDao;

	public List<QueryClass> getCustomerUsernameFromQuery(String username) {
		List<QueryClass> list3 = queryDao.getCustomerUsernameFromQuery(username);
		return list3;
	}

	public List<QueryClass> getTransporterUsernameFromQuery(String tusername) {
		List<QueryClass> list2 = queryDao.getTransporterUsernameFromQuery(tusername);
		return list2;
	}

	public QueryClass addData(String queryasked, String username, String tusername) {
		QueryClass query1 = queryDao.addData(queryasked, username, tusername);
		return query1;
	}

	public List<QueryClass> viewAll() {
		List<QueryClass> list1 = queryDao.viewAll();
		return list1;
	}

	public QueryClass addDataForResponse(String queryresponse, String qid, String tusername) {
		QueryClass query2 = queryDao.addDataForResponse(queryresponse, qid, tusername);
		return query2;
	}

	public List<QueryClass> viewAllResponse() {
		List<QueryClass> list2 = queryDao.viewAllResponse();
		return list2;
	}
}
