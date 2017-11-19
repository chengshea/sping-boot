package com.cs.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class SendEmail {
	
	    private static Logger logger = LoggerFactory.getLogger(SendEmail.class);
	
	    public static  String HOST;
	    public static  String PROTOCOL;
	    public static  int PORT;
	    public static  String SENDER ;
	    public static  String SENDERPWD ;
	      
	    @Value("${email.host}")
	    public  void setHOST(String hOST) {
			HOST = hOST;
		}
	    @Value("${email.protocol}")
		public  void setPROTOCOL(String pROTOCOL) {
			PROTOCOL = pROTOCOL;
		}
	    @Value("${email.port}")
		public  void setPORT(int pORT) {
			PORT = pORT;
		}
	    @Value("${email.sender}")
		public  void setSENDER(String sENDER) {
			SENDER = sENDER;
		}
	    @Value("${email.password}")
		public  void setSENDERPWD(String sENDERPWD) {
			SENDERPWD = sENDERPWD;
		}
	    
	    
	    
	    /** 
	     * 获取用于发送邮件的Session 
	     * @return 
	     */  
	    public static Session getSession() {  
	        Properties props = new Properties();  
	        props.put("mail.store.protocol" , PROTOCOL);//设置协议  
	        props.put("mail.smtp.host", HOST);//设置服务器地址  
	        props.put("mail.smtp.port", PORT);//设置端口  
	        props.put("mail.smtp.auth" , "true");  
	        props.put("mail.debug","true"); 
	        props.put("mail.smtp.starttls.enable","true"); 
	        props.put("mail.smtp.EnableSSL.enable","true");

	          
	        Authenticator authenticator = new Authenticator() {  
	            @Override  
	            protected PasswordAuthentication getPasswordAuthentication() {  
	                return new PasswordAuthentication(SENDER, SENDERPWD);  
	            }  
	        };  
	        Session session = Session.getDefaultInstance(props,authenticator);  
	        return session;  
	    }  
	      
	    /** 
	     * 发送邮件 
	     * @param receiver 
	     * @param content 
	     */  
	    public static String send(String receiver, String content) {  
	    	String str =null;
	        Session session = getSession();  
	        try {  
	            logger.info("-------开始发送-------");  
	            Message msg = new MimeMessage(session);  
	            //设置message属性  
	            msg.setFrom(new InternetAddress(SENDER));  
	            InternetAddress[] addrs = {new InternetAddress(receiver)};  
	            msg.setRecipients(Message.RecipientType.TO, addrs);  
	            msg.setSubject("帐号激活");  
	            msg.setSentDate(new Date());  
	            msg.setContent(content,"text/html;charset=utf-8");  
	            //开始发送  
	            Transport.send(msg);  
	            logger.info("-------发送完成-------");  
	                        str="发送完成";
	        } catch (AddressException e) {  
	            e.printStackTrace();  
	        } catch (MessagingException e) {  
	            e.printStackTrace();  
	        }
			return str;  
	    }  
}
