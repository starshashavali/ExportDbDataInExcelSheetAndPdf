package com.student.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender emailSender;

	public void sendEmailWithAttachment(String to,
			String subject, 
			String text,
			String pathToAttachment) throws MessagingException {
	    MimeMessage message = emailSender.createMimeMessage();

	    // use the true flag to indicate you need a multipart message
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);

	    helper.setFrom("javashashavali@gmail.com");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);

	    // attach the file
	    FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
	    helper.addAttachment(file.getFilename(), file);

	    emailSender.send(message);
	    System.out.println("Mail with attachment sent successfully");


}
}