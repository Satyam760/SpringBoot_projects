package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("mailService")
public class PurchaseOrderServiceImpl implements IPurchaseOrder {

	@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	
	@Override
	public String purchase(String[] items, double[] price, String[] toEmails) throws Exception {
		//calculate the bill amount
		double billAmt=0.0;
		for(double p:price)
			billAmt=billAmt+p;
		String msg=Arrays.toString(items)+" with price "+Arrays.toString(price)+" are purchsed with billAmount"+billAmt;
		//send mail
		String status=sendMail(msg,toEmails);
		return msg+"----->"+status;
	}
	
	private String sendMail(String msg,String[] toEmails)throws Exception {
		MimeMessage message=sender.createMimeMessage();  //empty email message
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("open it to know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("couples.jpg",new ClassPathResource("couples.jpg"));
		sender.send(message);
		return " mail sent ";
		
	}
	

}
