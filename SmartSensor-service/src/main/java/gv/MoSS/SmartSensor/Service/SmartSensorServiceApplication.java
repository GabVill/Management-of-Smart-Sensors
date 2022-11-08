package gv.MoSS.SmartSensor.Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import controllers.SmartSensorController;

@SpringBootApplication
@ComponentScan(basePackageClasses = SmartSensorController.class)
public class SmartSensorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartSensorServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
