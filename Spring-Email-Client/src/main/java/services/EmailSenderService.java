package services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import models.Email;
import valueObject.User;
import valueObject.UserResponse;



@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private RestTemplate restTemplate;

	
	public void sendEmail(int id) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
			Email email;
		
			UserResponse vo = new UserResponse();
				
			User user = restTemplate.getForObject("http://USER-SERVICE/users/"+id, User.class);
			
			vo.setUser(user);
			
			
			email = user.getEmail();		
		try {
			if (email.getSendTo().contains(",")) {
				String[] emails = email.getSendTo().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {

					msg.setTo(emails[i]);
					msg.setSubject("MoSS: Superamento Soglia!");
					msg.setText("Il valore rilevato dal sensore ha superato la soglia da lei impostata! ");
					javaMailSender.send(msg);
				}

			} else {
				msg.setTo(email.getSendTo());
				msg.setSubject("MoSS: Superamento Soglia!");
				msg.setText("Il valore rilevato dal sensore ha superato la soglia da lei impostata! ");
				javaMailSender.send(msg);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
