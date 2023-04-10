package com.laptrinhjavaweb.helper;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;

public class GmailHelper {
	private final String username = "dungsongoku3@gmail.com";
    private final String password = "enlrbzbddzmuslqn";
    
    public void guiXacThucGmail (String toGmail, String maXacThuc){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");//TLS
        
        Session session = Session.getInstance(properties, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication(){
                return  new PasswordAuthentication(username, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            MimeBodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(message, "text/html; charset=utf-8");
            message.addHeader("Content-type", "text/HTML; charset=UTF-8");
            message.addHeader("format", "flowed");
            message.addHeader("Content-Transfer-Encoding", "8bit");
            message.setFrom(new InternetAddress("dungsongoku3@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO , 
                    InternetAddress.parse(toGmail)
            );
            message.setSubject("Xác Nhận Thông Tin Đăng Nhập","UTF-8");
            message.setText("Mã Xác Thực Được Gửi"
                +"\nMã Xác Thực là:"+maXacThuc,"UTF-8");
            Transport.send(message);
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi ở phần GmailHelper");
        }
    }
}
