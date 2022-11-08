package gv.MoSS.User.Service;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

import controllers.UserController;




@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}