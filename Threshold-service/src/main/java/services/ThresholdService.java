package services;


import java.util.List;
import java.util.Optional;


import models.Threshold;
import models.ThresholdType;
import repositories.ThresholdRepository;
import valueObject.SmartSensorResponse;
import valueObject.SmartSensor;
import valueObject.User;
import valueObject.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@EnableMongoRepositories(basePackageClasses = ThresholdRepository.class)
public class ThresholdService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	private ThresholdRepository thresholdRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;


	public List<Threshold> getAllThresholds() {
		return thresholdRepository.findAll();
	}

	public Optional<Threshold> getThresholdById(int id) {

		return thresholdRepository.findById(id);
	}
	
	public String save(Threshold threshold){
		thresholdRepository.save(threshold);
		return "Added threshold into the db with Id" + threshold.getThresholdId();
	}

	public String updateThreshold(int id,Threshold threshold) {
		Query query = new Query();
		query.addCriteria(Criteria.where("thresholdId").is(id));
		mongoTemplate.find(query, Threshold.class);
		thresholdRepository.save(threshold);
		
		return "Updated threshold into the db with Id" + threshold.getThresholdId();

	}

	public String deleteThreshold(int id) {
		thresholdRepository.deleteById(id);

		return "Deleted threshold from the db with Id" + id;
	}
	
	public SmartSensorResponse getSensorId(int id) {
		SmartSensorResponse vo = new SmartSensorResponse();
		Query query = new Query();
		query.addCriteria(Criteria.where("thresholdId").is(id));
		List<Threshold> thresholds = mongoTemplate.find(query, Threshold.class);
		for(int i=0;i<thresholds.size();i++) {
			
		SmartSensor smartSensor = restTemplate.getForObject("http://SMART-SENSOR-SERVICE/sensors/"+thresholds.get(i).getSensorId(), SmartSensor.class);
		
		
		vo.setSmartSensor(smartSensor);
		vo.setThreshold(thresholds.get(i));
	}
		return vo;
	}
	
	public UserResponse getUserId(int id) {
		UserResponse vo = new UserResponse();
		Query query = new Query();
		query.addCriteria(Criteria.where("thresholdId").is(id));
		List<Threshold> thresholds = mongoTemplate.find(query, Threshold.class);
		for(int i=0;i<thresholds.size();i++) {
			
		User user = restTemplate.getForObject("http://USER-SERVICE/users/"+thresholds.get(i).getUserId(), User.class);
		
		
		vo.setUser(user);
		vo.setThreshold(thresholds.get(i));
	}
		return vo;
	}
	
	public String ThresholdExceeded (int id) {
		SmartSensorResponse sr = new SmartSensorResponse();
		UserResponse ur = new UserResponse();
		ThresholdType t = ThresholdType.MIN;
	
		sr=this.getSensorId(id);
		
		SmartSensor smartSensor= sr.getSmartSensor();
		Threshold threshold = sr.getThreshold();
		if(threshold.getType()==t) {
			if(smartSensor.getValue() < threshold.getValue()){
				ur=this.getUserId(id);
				
				User user=ur.getUser();
				restTemplate.execute("//EMAIL-SERVICE/EmailSender/notification/"+user.getUserId(), HttpMethod.POST, null, null);
				return "The threshold is exceeded , send email to the user!";
			}
			else {
				return "nothing to report";
			}
		}
		else {
			if(smartSensor.getValue() > threshold.getValue()){
				ur=this.getUserId(id);
				
				User user=ur.getUser();
				restTemplate.execute("//EMAIL-SERVICE/EmailSender/notification/"+user.getUserId(), HttpMethod.POST, null, null);
				return "The threshold is exceeded , send email to the user!";
			}
			else {
				return "nothing to report";
			}
		}			
	}
			
	
}