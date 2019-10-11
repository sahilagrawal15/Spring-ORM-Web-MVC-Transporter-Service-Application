package com.worldpay.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.worldpay.dao.TransporterDao;
import com.worldpay.entities.Customer;
import com.worldpay.entities.Transporter;

@Service
public class TransporterServiceImplementation implements TransporterService {

	@Autowired
	private TransporterDao transporterDao;

	@Autowired
	JavaMailSender mailSender;

	public Transporter addData(Transporter transporter) {
		Transporter transporter1 = transporterDao.addData(transporter);
		return transporter1;
	}

	public Transporter searchTransporter(String tusername) {
		Transporter transporter = transporterDao.searchTransporter(tusername);
		return transporter;
	}

	public Transporter verifyTransporter(Transporter transporter) {
		Transporter transporter1 = transporterDao.verifyTransporter(transporter);
		return transporter1;
	}

	public List<Transporter> viewAll() {

		List<Transporter> list = new ArrayList<Transporter>();
		list = transporterDao.viewAll();

		return list;
	}

	public void approveData(String username) {

		transporterDao.approve(username);
	}

	public void sendMail2(Transporter transporter) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(transporter.getTusername());
		mailMessage.setSubject("Approval Successfull");
		mailMessage.setText("Hey There!, You can now access the features of this website....Login Now");
		mailSender.send(mailMessage);

	}

	public Transporter updateTransporter(String tusername) {
		Transporter transporter1 = new Transporter();
		transporter1 = transporterDao.update(tusername);
		return transporter1;
	}

	public Transporter updateData(Transporter transporter) {
		Transporter transporter1 = new Transporter();
		transporter1 = transporterDao.updateData(transporter);
		return transporter1;
	}

	public void deleteTransporter(String tusername) {

		transporterDao.deleteTransporter(tusername);

	}

	public void sendMail3(Transporter transporter) {
	//	try{
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(transporter.getTusername());
		mailMessage.setSubject("Account Deactivated");
		mailMessage.setText(
				"Your account has been suspended as your vehicles and documents are found invalid...You can register again in future and can access if all documents are valid.....All the posted deals and vehicles are also disabled");
		mailSender.send(mailMessage);
	//	}
		/*catch(Exception e)
		{
			e.printStackTrace();
		}
*/
	}

}
