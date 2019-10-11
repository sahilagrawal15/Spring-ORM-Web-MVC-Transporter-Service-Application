package com.worldpay.dao;
import java.util.List;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Transporter;

public interface TransporterDao {
	
	public Transporter addData(Transporter transporter);
	public Transporter searchTransporter(String tusername);
	public Transporter verifyTransporter(Transporter transporter);
	public List<Transporter> viewAll();
	public void approve(String username);
	public Transporter update(String tusername);
	public Transporter updateData(Transporter transporter);
	public void deleteTransporter(String tusername);


}
