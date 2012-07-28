package com.gceylan.ajanda;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
 
public class SendMail {
	
	private static final Logger logger = Logger.getLogger(SendMail.class);
	
	private String username;
	private String password;
	
	public SendMail() {
		username = "gokhan.ceylan@bil.omu.edu.tr";
		password = "ben13753535866";
	}
	
	public void send(String subject, String message) {
		
		// mail gonderme protokolleri (smtp)
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message m = new MimeMessage(session);
			m.setFrom(new InternetAddress("deneme@gmail.com"));
			m.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("gokhan.ceylan@bil.omu.edu.tr"));
			m.setSubject(subject);
			m.setText(message);
 
			Transport.send(m);
 
		} catch (MessagingException e) {
			logger.error("MAIL NOT SENDED!");
			throw new RuntimeException(e);
		}
	}
}