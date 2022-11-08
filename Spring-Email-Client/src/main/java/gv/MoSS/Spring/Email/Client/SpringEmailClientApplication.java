package gv.MoSS.Spring.Email.Client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import controllers.EmailSenderController;


@SpringBootApplication
@ComponentScan(basePackageClasses = EmailSenderController.class)
public class SpringEmailClientApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
}
