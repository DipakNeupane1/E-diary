package com.dipak.myediary.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailUtil {

	public static void sendEmail(MailSender mailSender,String toAddress, String fromAddress, String subject, String msgBody) {
		 
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(fromAddress);
		msg.setTo(toAddress);
		msg.setSubject(subject);
		msg.setText(msgBody);
		mailSender.send(msg);
	}
}
