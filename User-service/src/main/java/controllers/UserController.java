package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.User;
import services.UserService;



@RestController
@ComponentScan(basePackageClasses = UserService.class)
public class UserController{
	
	@Autowired
	private UserService userService;	
	
	
	@PostMapping("/users/add")
	public String save(@RequestBody User user) {
		return	userService.save(user);
	}
	
	
	@GetMapping("/users")
	public List<User> getAllUsers() {

		return userService.getAllUsers();
		}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable int id) {

		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "/users/update/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable int id, @RequestBody User user){
		return userService.updateUser(id, user);
	}

	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int id){
		return userService.deleteUser(id);
	}
}