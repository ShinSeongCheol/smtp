package smtp;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class SendEmail {
    public void sendMail(String address, String subject, String content) throws Exception {
    	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    	// 이메일 객체생성하기
    	Properties props = System.getProperties();
    	props.setProperty("mail.smtp.host", "smtp.gmail.com");
    	props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    	props.setProperty("mail.smtp.socketFactory.fallback", "false");
    	props.setProperty("mail.smtp.port", "465");
    	props.setProperty("mail.smtp.socketFactory.port", "465");
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.debug", "true");
    	props.put("mail.store.protocol", "pop3");
    	props.put("mail.transport.protocol", "smtp");
    	final String username = "mail-address@gmail.com";//
    	final String password = "password";

    	try{
    	    Session session = Session.getDefaultInstance(props, 
    	    new Authenticator(){
    	    protected PasswordAuthentication getPasswordAuthentication() {
    	    return new PasswordAuthentication(username, password);
    	}});

    	//메세지 설정
    	Message msg = new MimeMessage(session);

    	//보내는사람 받는사람 설정
    	msg.setFrom(new InternetAddress("mail-address@gmail.com"));
    	msg.setRecipients(Message.RecipientType.TO, 
    						InternetAddress.parse(address,false));
    	msg.setSubject(subject);
    	msg.setText(content);
    	msg.setSentDate(new Date());
    	Transport.send(msg);
    	System.out.println("발신성공!");

    	}catch (MessagingException error){ 
    		System.out.println("에러가 발생했습니다: " + error);
    	}
    }
}