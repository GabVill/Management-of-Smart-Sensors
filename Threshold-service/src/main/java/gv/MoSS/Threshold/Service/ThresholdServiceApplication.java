package gv.MoSS.Threshold.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import controllers.ThresholdController;

@SpringBootApplication
@ComponentScan(basePackageClasses = ThresholdController.class)
public class ThresholdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThresholdServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
