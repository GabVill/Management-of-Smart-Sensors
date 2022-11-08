package services;


import models.User;
import repositories.UserRepository;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import org.springframework.stereotype.Service;

@Service
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String save(User user) {
		userRepository.save(user);
		return "Added user into the db with Id" + user.getUserId();
}

	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(int id) {

		return userRepository.findById(id);
	}
	
	public String updateUser(int id,User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(id));
		mongoTemplate.find(query, User.class);
		userRepository.save(user);
		
		return "Updated user into the db with Id" + user.getUserId();
			
	}

	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "Deleted user from the db with Id" + id;
	}
}