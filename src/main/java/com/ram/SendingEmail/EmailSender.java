package com.ram.SendingEmail;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	DataModel dataModel;

	void sendEmail(String pin, String text) {

		SimpleMailMessage msg = new SimpleMailMessage();
		String[] emails=dataModel.getSearchData().get(pin).stream().toArray((email -> new String[email]));
		msg.setTo(emails);

		msg.setSubject("Vaccine availability");
		msg.setText(text);

		javaMailSender.send(msg);

	}

	void sendEmailWithAttachment() throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo("email address to whom you send the mail");

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>Check attachment for image!</h1>", true);

		// hard coded a file path
		FileSystemResource file = new FileSystemResource(new File("C:/Users\\1302143\\Desktop\\ssl4.png"));

		helper.addAttachment("ssl4.png", file);

		javaMailSender.send(msg);

	}
}
