/**
 * Project Name:hfchi
 * File Name:Email.java
 * Package Name:com.jlkj.chw.util
 * Date:2017年11月6日下午3:37:45
 * @author 桔子
 *
 */
package com.jlkj.chw.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import sun.misc.BASE64Encoder;

public class Email {
	private static String server_mail = "smtp.163.com";
	private static String subject = "验证码，请在5分钟内验证，过期无效";
	private static String content;
	private static final String password = "a123a123";
	private static final BASE64Encoder encode = new BASE64Encoder();
	private String myEmailAccount = "saygnooo@163.com";
	private boolean isSuccess = true;

	public Email() throws Exception {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			sb.append(base.charAt(random.nextInt(base.length())));
		}
		content = new String(sb);
		content = "你好!盼星星，盼月亮，终于盼来了你！灰常欢迎来到桔子零食！\n这里有最新、最全、最好吃的零食，涵盖中日韩等各国食品。\n据不完全统计，每年有至少80%的学生在这里买零食哦！\n不知道吃什么，就来桔子零食，海量美味任你挑选哦！\n";
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static boolean send(String targetMail, String code) throws Exception {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", server_mail);
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		final String username = "saygnooo@163.com";
		final String password = "a123a123";
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		session.setDebug(true);
		// -- Create a new message --
		Message msg = new MimeMessage(session);

		// -- Set the FROM and TO fields --
		msg.setFrom(new InternetAddress(username));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(targetMail, false));
		msg.setSubject(subject);
		
		Random r=new Random();		
		int n = r.nextInt(3);
		if(n==0)
		{
			content = "您的验证码为:" + code + ",该验证码5分钟内有效,请勿泄露于他人";
		}else if (n==1) {
			content = "该验证码5分钟内有效,请勿泄露于他人,您的验证码为:" + code;
		}else {
			content = "感谢注册您的验证码为:" + code + ",请勿泄露于他人";
		}
		msg.setText(content);
		msg.setSentDate(new Date());
		Transport.send(msg);

		return true;

	}

	public MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "尊敬的用户", "UTF-8"));
		message.setSubject(subject, "UTF-8");
		message.setContent(content, "text/html;charset=UTF-8");
		message.setSentDate(new java.util.Date());
		message.saveChanges();
		return message;
	}

	public static void main(String[] args) {
		try {
			Email.send("841376896@qq.com", Code.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
