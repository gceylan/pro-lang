import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMail {
	
	private String username;
	private String password;
	
	public SendMail() {
		username = "gokhan.ceylan@bil.omu.edu.tr";
		password = "şifre";
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
			m.setFrom(new InternetAddress("from-email@gmail.com"));
			m.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-email@gmail.com"));
			m.setSubject(subject);
			m.setText(message);
 
			Transport.send(m);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
