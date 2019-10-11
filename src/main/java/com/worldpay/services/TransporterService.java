package com.worldpay.services;

import java.util.List;

import com.worldpay.entities.Customer;
import com.worldpay.entities.Transporter;

public interface TransporterService {
	
	public Transporter addData(Transporter transporter);
	public Transporter searchTransporter(String tusername);
	public Transporter verifyTransporter(Transporter transporter);
	public List<Transporter> viewAll();
	public void approveData(String username);
	public void sendMail2(Transporter transporter);
	public Transporter updateTransporter(String tusername);
	public Transporter updateData(Transporter transporter);
	public void deleteTransporter(String tusername);
	public void sendMail3(Transporter transporter);

}
