package com.dipak.myediary.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dipak.myediary.service.FriendsService;

@Controller
public class EmailController {

	final String emailFromRecipient = "dipakneupane805@gmail.com";

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private FriendsService friendsService;

	@RequestMapping(value = "/send_email", method = RequestMethod.GET)
	public String showEmailForm(Model model,@RequestParam int fid) {
		model.addAttribute("birthday",friendsService.getFriendByFid(fid));
		return "emailForm";
	}
	// This Method Is Used To Prepare The Email Message And Send It To The Client
	@RequestMapping(value ="/sendemail", method = RequestMethod.POST)
	public ModelAndView sendEmailToClient(HttpServletRequest request,
			@RequestParam CommonsMultipartFile attachFileObj) {

		// Reading Email Form Input Parameters
		String emailSubject = request.getParameter("subject");
		String emailMessage = request.getParameter("message");
		String emailToRecipient = request.getParameter("mailTo");

		// Logging The Email Form Parameters For Debugging Purpose
		System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= "
				+ emailMessage + "\n");

		mailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emailSubject);

				// Determine If There Is An File Upload. If Yes, Attach It To The Client Email
				if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
					System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
					mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {
						public InputStream getInputStream() throws IOException {
							return attachFileObj.getInputStream();
						}
					});
				} else {
					System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
				}
			}
		});
		System.out.println("\nMessage Send Successfully.... Hurrey!\n");

		return new ModelAndView("success", "messageObj", "Thank You! Your Email Has Been Sent!");
	}
}


