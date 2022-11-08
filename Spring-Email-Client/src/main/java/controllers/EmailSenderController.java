package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import models.Email;
import services.EmailSenderService;

@RestController
@ComponentScan(basePackageClasses = EmailSenderService.class)
public class EmailSenderController {

	@Autowired
	private EmailSenderService emailService;

	@PostMapping("/EmailSender/notification/{id}")
	public String sendEmail(@PathVariable int id) {
		try {
			emailService.sendEmail(id);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}
	

}
