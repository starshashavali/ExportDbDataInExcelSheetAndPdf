package com.student;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.student.service.EmailSenderService;

@SpringBootApplication
public class SpringEmailAttachmentApplication {
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailAttachmentApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail()  throws MessagingException{
		emailSenderService.sendEmailWithAttachment("javashashavali@gmail.com", "Sending Mail", 
				"body","D:\\books\\name.pdf");
	}

}
